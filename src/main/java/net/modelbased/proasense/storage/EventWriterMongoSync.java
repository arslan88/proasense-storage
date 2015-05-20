/**
 * Copyright (C) 2014-2015 SINTEF
 *
 *     Brian Elvesæter <brian.elvesater@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.modelbased.proasense.storage;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;


public class EventWriterMongoSync implements Runnable {
    private Properties mongoProperties;
    private MongoClient mongoClient;
    private BlockingQueue<EventDocument> queue;
    private String mongoURL;
    private int bulkSize;
    private int maxWait;


    public EventWriterMongoSync(BlockingQueue<EventDocument> queue, String mongoURL, int bulkSize, int maxWait) {
        this.queue = queue;
        this.mongoURL = mongoURL;
        this.bulkSize = bulkSize;
        this.maxWait = maxWait;
    }


    public void run() {
        // Connect to MongoDB database
        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoURL));
        MongoDatabase database = mongoClient.getDatabase(EventProperties.STORAGE_DATABASE_NAME);

        // Create hash map of collections
        Map<String, MongoCollection<Document>> collectionMap = new HashMap<String, MongoCollection<Document>>();

        int cnt = 0;
        long timer1 = System.currentTimeMillis();
        long timer2 = System.currentTimeMillis();

        Map<String, List<Document>> documentMap = new HashMap<String, List<Document>>();
        try {
            while (true) {
                cnt++;
                long timeoutExpired = System.currentTimeMillis() + this.maxWait;
                EventDocument eventDocument = queue.take();

                String collectionId = eventDocument.getCollectionId();

                // Add data for bulk write
                if (!collectionId.matches(EventProperties.STORAGE_HEARTBEAT)) {
                    Document document = eventDocument.getDocument();

                    if (!collectionMap.containsKey(collectionId)) {
                        collectionMap.put(collectionId, database.getCollection(collectionId));
                        List<Document> documentList = new ArrayList<Document>();
                        documentMap.put(collectionId, documentList);
                    }

                    documentMap.get(collectionId).add(document);
                }
                // Write data if heartbeat timeout is received
                else {
                    for (Map.Entry<String, MongoCollection<Document>> entry : collectionMap.entrySet()) {
                        String key = entry.getKey();
                        if (!documentMap.get(key).isEmpty()) {
                            collectionMap.get(key).insertMany(documentMap.get(key));
                            documentMap.get(key).clear();
                        }
                    }
                }

                // Write data if bulk size or max wait (ms) is reached
                if ((cnt % this.bulkSize == 0) || (System.currentTimeMillis() >= timeoutExpired)) {
                    for (Map.Entry<String, MongoCollection<Document>> entry : collectionMap.entrySet()) {
                        String key = entry.getKey();
                        if (!documentMap.get(key).isEmpty()) {
                            collectionMap.get(key).insertMany(documentMap.get(key));
                            documentMap.get(key).clear();
                        }
                    }
                }

                if (cnt % this.bulkSize == 0) {
                    timer2 = System.currentTimeMillis();
                    long average = (this.bulkSize*1000) / (timer2 - timer1);
                    System.out.println("Benchmark: ");
                    System.out.println("  Total records written: " + cnt);
                    System.out.println("  Average records/s: " + average);
                    timer1 = timer2;
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
        }

        mongoClient.close();
    }

}