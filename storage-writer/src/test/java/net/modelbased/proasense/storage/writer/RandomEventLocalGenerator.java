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
package net.modelbased.proasense.storage.writer;

import eu.proasense.internal.AnomalyEvent;
import eu.proasense.internal.DerivedEvent;
import eu.proasense.internal.FeedbackEvent;
import eu.proasense.internal.PredictedEvent;
import eu.proasense.internal.RecommendationEvent;
import eu.proasense.internal.SimpleEvent;

import net.modelbased.proasense.storage.EventDocument;
import net.modelbased.proasense.storage.EventDocumentConverter;
import net.modelbased.proasense.storage.EventProperties;

import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

import java.util.concurrent.BlockingQueue;


public class RandomEventLocalGenerator<T> implements Runnable {
    private Class<T> eventType;
    private BlockingQueue<EventDocument> queue;
    private String bootstrapServers;
    private String groupId;
    private String topic;
    private String collectionId;
    private int sleep;
    private int max;
    private RandomEventGenerator eventGenerator;


    public RandomEventLocalGenerator(Class<T> eventType, BlockingQueue<EventDocument> queue, String collectionId, int sleep, int max) {
        this.eventType = eventType;
        this.queue = queue;
        this.bootstrapServers = bootstrapServers;
        this.groupId = groupId;
        this.topic = topic;
        this.collectionId = collectionId;
        this.sleep = sleep;
        this.max = max;
        this.eventGenerator = new RandomEventGenerator();
    }


    public void run() {
        int cnt = 0;
        try {
            while (cnt < this.max) {
                cnt++;
                Thread.sleep(this.sleep);

                String eventTypeName = eventType.getName();

                // Generate simple event with random values
                if (eventTypeName.matches(EventProperties.SIMPLEEVENT_CLASS_NAME)) {
                    T event = (T)eventGenerator.generateSimpleEvent(this.collectionId);

                    // Serialize message
                    TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
                    byte[] bytes = serializer.serialize((SimpleEvent)event);

                    EventDocumentConverter converter = new EventDocumentConverter((SimpleEvent)event);
                    EventDocument eventDocument = new EventDocument(converter.getCollectionId(), converter.getDocument());

                    queue.put(eventDocument);

//                    if (cnt % 1000 == 0)
//                        System.out.println("SimpleEvent(" + cnt + "): " + event.toString());
                }

                // Generate derived event with random values
                if (eventTypeName.matches(EventProperties.DERIVEDEVENT_CLASS_NAME)) {
                    T event = (T) eventGenerator.generateDerivedEvent(this.collectionId);

                    // Serialize message
                    TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
                    byte[] bytes = serializer.serialize((DerivedEvent)event);

                    EventDocumentConverter converter = new EventDocumentConverter((DerivedEvent)event);
                    EventDocument eventDocument = new EventDocument(converter.getCollectionId(), converter.getDocument());

                    queue.put(eventDocument);

//                    if (cnt % 1000 == 0)
//                        System.out.println("DerivedEvent(" + cnt + "): " + event.toString());
                }

                // Generate predicted event with random values
                if (eventTypeName.matches(EventProperties.PREDICTEDEVENT_CLASS_NAME)) {
                    T event = (T)eventGenerator.generatePredictedEvent(EventProperties.PREDICTEDEVENT_STORAGE_COLLECTION_NAME);

                    // Serialize message
                    TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
                    byte[] bytes = serializer.serialize((PredictedEvent)event);

                    EventDocumentConverter converter = new EventDocumentConverter((PredictedEvent)event);
                    EventDocument eventDocument = new EventDocument(converter.getCollectionId(), converter.getDocument());

                    queue.put(eventDocument);

//                    if (cnt % 1000 == 0)
//                        System.out.println("PredictedEvent(" + cnt + "): " + event.toString());
                }

                // Generate anomaly event with random values
                if (eventTypeName.matches(EventProperties.ANOMALYEVENT_CLASS_NAME)) {
                    T event = (T)eventGenerator.generateAnomalyEvent(EventProperties.ANOMALYEVENT_STORAGE_COLLECTION_NAME);

                    // Serialize message
                    TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
                    byte[] bytes = serializer.serialize((AnomalyEvent)event);

                    EventDocumentConverter converter = new EventDocumentConverter((AnomalyEvent)event);
                    EventDocument eventDocument = new EventDocument(converter.getCollectionId(), converter.getDocument());

                    queue.put(eventDocument);

//                    if (cnt % 1000 == 0)
//                        System.out.println("AnomalyEvent(" + cnt + "): " + event.toString());
                }

                // Generate recommendation event with random values
                if (eventTypeName.matches(EventProperties.RECOMMENDATIONEVENT_CLASS_NAME)) {
                    T event = (T)eventGenerator.generateRecommendationEvent(EventProperties.RECOMMENDATIONEVENT_STORAGE_COLLECTION_NAME);

                    // Serialize message
                    TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
                    byte[] bytes = serializer.serialize((RecommendationEvent)event);

                    EventDocumentConverter converter = new EventDocumentConverter((RecommendationEvent)event);
                    EventDocument eventDocument = new EventDocument(converter.getCollectionId(), converter.getDocument());

                    queue.put(eventDocument);

//                    if (cnt % 1000 == 0)
//                        System.out.println("RecommendationEvent(" + cnt + "): " + event.toString());
                }

                // Generate feedback event with random values
                if (eventTypeName.matches(EventProperties.FEEDBACKEVENT_CLASS_NAME)) {
                    T event = (T)eventGenerator.generateFeedbackEvent(EventProperties.FEEDBACKEVENT_STORAGE_COLLECTION_NAME);

                    // Serialize message
                    TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
                    byte[] bytes = serializer.serialize((FeedbackEvent)event);

                    EventDocumentConverter converter = new EventDocumentConverter((FeedbackEvent)event);
                    EventDocument eventDocument = new EventDocument(converter.getCollectionId(), converter.getDocument());

                    queue.put(eventDocument);

//                    if (cnt % 1000 == 0)
//                        System.out.println("FeedbackEvent(" + cnt + "): " + event.toString());
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        } catch (TException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
        }
    }

}
