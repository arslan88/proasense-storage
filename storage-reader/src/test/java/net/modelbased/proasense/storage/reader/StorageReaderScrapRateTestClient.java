/**
 * Copyright (C) 2014-2016 SINTEF
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
package net.modelbased.proasense.storage.reader;

import eu.proasense.internal.SimpleEvent;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.protocol.TJSONProtocol;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


public class StorageReaderScrapRateTestClient {
    private Properties clientProperties;


    public StorageReaderScrapRateTestClient() {
    }


    private Properties loadClientProperties() {
        clientProperties = new Properties();
        String propFilename = "client.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFilename);

        try {
            if (inputStream != null) {
                clientProperties.load(inputStream);
            } else
                throw new FileNotFoundException("Property file: '" + propFilename + "' not found in classpath.");
        }
        catch (IOException e) {
            System.out.println("Exception:" + e.getMessage());
        }

        return clientProperties;
    }


    public static void main(String[] args) {
        // Get client properties from properties file
//        StorageReaderMongoServiceTestClient client = new StorageReaderMongoServiceTestClient();
//        client.loadClientProperties();

        // Hardcoded client properties (simple test client)
        String STORAGE_READER_SERVICE_URL = "http://192.168.84.34:8080/storage-reader";

        String QUERY_SIMPLE_SENSORID = "1000692";
        String QUERY_SIMPLE_STARTTIME = "1387565891068";
        String QUERY_SIMPLE_ENDTIME = "1387565996633";
        String QUERY_SIMPLE_PROPERTYKEY = "value";

        // Default HTTP client and common properties for requests
        HttpClient client = new DefaultHttpClient();
        StringBuilder requestUrl = null;
        List<NameValuePair> params = null;
        String queryString = null;

        // Default HTTP response and common properties for responses
        HttpResponse response = null;
        ResponseHandler<String> handler = null;
        int status = 0;
        String body = null;

        // Default query for simple events
        requestUrl = new StringBuilder(STORAGE_READER_SERVICE_URL);
        requestUrl.append("/query/simple/default");

        params = new LinkedList<NameValuePair>();
        params.add(new BasicNameValuePair("sensorId", QUERY_SIMPLE_SENSORID));
        params.add(new BasicNameValuePair("startTime", QUERY_SIMPLE_STARTTIME));
        params.add(new BasicNameValuePair("endTime", QUERY_SIMPLE_ENDTIME));

        queryString = URLEncodedUtils.format(params, "utf-8");
        requestUrl.append("?");
        requestUrl.append(queryString);

        try {
            HttpGet query11 = new HttpGet(requestUrl.toString());
            query11.setHeader("Content-type", "application/json");
            response = client.execute(query11);

            // Check status code
            status = response.getStatusLine().getStatusCode();
            if (status != 200) {
                throw new RuntimeException("Failed! HTTP error code: " + status);
            }

            // Get body
            handler = new BasicResponseHandler();
            body = handler.handleResponse(response);

            System.out.println("SIMPLE.DEFAULT: " + body);
            // The result is an array of simple events serialized as JSON using Apache Thrift.
            // The simple events can be deserialized into Java objects using Apache Thrift.

            ObjectMapper mapper = new ObjectMapper();
            JsonNode nodeArray = mapper.readTree(body);

            for (JsonNode node : nodeArray) {
                byte[] bytes = node.toString().getBytes();
                TDeserializer deserializer = new TDeserializer(new TJSONProtocol.Factory());
                SimpleEvent event = new SimpleEvent();
                deserializer.deserialize(event, bytes);
                System.out.println(event.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }

        // Average query for simple events
        requestUrl = new StringBuilder(STORAGE_READER_SERVICE_URL);
        requestUrl.append("/query/simple/average");

        params = new LinkedList<NameValuePair>();
        params.add(new BasicNameValuePair("sensorId", QUERY_SIMPLE_SENSORID));
        params.add(new BasicNameValuePair("startTime", QUERY_SIMPLE_STARTTIME));
        params.add(new BasicNameValuePair("endTime", QUERY_SIMPLE_ENDTIME));
        params.add(new BasicNameValuePair("propertyKey", QUERY_SIMPLE_PROPERTYKEY));

        queryString = URLEncodedUtils.format(params, "utf-8");
        requestUrl.append("?");
        requestUrl.append(queryString);

        try {
            HttpGet query12 = new HttpGet(requestUrl.toString());
            query12.setHeader("Content-type", "application/json");
            response = client.execute(query12);

            // Get status code
            status = response.getStatusLine().getStatusCode();
            if (status == 200) {
                // Get body
                handler = new BasicResponseHandler();
                body = handler.handleResponse(response);

                System.out.println("SIMPLE.AVERAGE: " + body);
            }
            else
                System.out.println("Error code: " + status);
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }

        // Maximum query for simple events
        requestUrl = new StringBuilder(STORAGE_READER_SERVICE_URL);
        requestUrl.append("/query/simple/maximum");

        params = new LinkedList<NameValuePair>();
        params.add(new BasicNameValuePair("sensorId", QUERY_SIMPLE_SENSORID));
        params.add(new BasicNameValuePair("startTime", QUERY_SIMPLE_STARTTIME));
        params.add(new BasicNameValuePair("endTime", QUERY_SIMPLE_ENDTIME));
        params.add(new BasicNameValuePair("propertyKey", QUERY_SIMPLE_PROPERTYKEY));

        queryString = URLEncodedUtils.format(params, "utf-8");
        requestUrl.append("?");
        requestUrl.append(queryString);

        try {
            HttpGet query13 = new HttpGet(requestUrl.toString());
            query13.setHeader("Content-type", "application/json");
            response = client.execute(query13);

            // Get status code
            if (status == 200) {
                // Get body
                handler = new BasicResponseHandler();
                body = handler.handleResponse(response);

                System.out.println("SIMPLE.MAXIMUM: " + body);
            }
            else
                System.out.println("Error code: " + status);
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }

        // Minimum query for simple events
        requestUrl = new StringBuilder(STORAGE_READER_SERVICE_URL);
        requestUrl.append("/query/simple/minimum");

        params = new LinkedList<NameValuePair>();
        params.add(new BasicNameValuePair("sensorId", QUERY_SIMPLE_SENSORID));
        params.add(new BasicNameValuePair("startTime", QUERY_SIMPLE_STARTTIME));
        params.add(new BasicNameValuePair("endTime", QUERY_SIMPLE_ENDTIME));
        params.add(new BasicNameValuePair("propertyKey", QUERY_SIMPLE_PROPERTYKEY));

        queryString = URLEncodedUtils.format(params, "utf-8");
        requestUrl.append("?");
        requestUrl.append(queryString);

        try {
            HttpGet query14 = new HttpGet(requestUrl.toString());
            query14.setHeader("Content-type", "application/json");
            response = client.execute(query14);

            // Get status code
            if (status == 200) {
                // Get body
                handler = new BasicResponseHandler();
                body = handler.handleResponse(response);

                System.out.println("SIMPLE.MINIMUM: " + body);
            }
            else
                System.out.println("Error code: " + status);
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
