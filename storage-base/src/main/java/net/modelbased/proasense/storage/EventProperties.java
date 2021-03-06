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

public class EventProperties {
    public static String SIMPLEEVENT_CLASS_NAME = "eu.proasense.internal.SimpleEvent";
    public static String DERIVEDEVENT_CLASS_NAME = "eu.proasense.internal.DerivedEvent";
    public static String PREDICTEDEVENT_CLASS_NAME = "eu.proasense.internal.PredictedEvent";
    public static String ANOMALYEVENT_CLASS_NAME = "eu.proasense.internal.AnomalyEvent";
    public static String RECOMMENDATIONEVENT_CLASS_NAME = "eu.proasense.internal.RecommendationEvent";
    public static String FEEDBACKEVENT_CLASS_NAME = "eu.proasense.internal.FeedbackEvent";

    public static String SIMPLEEVENT_STORAGE_COLLECTION_PREFIX = "simple.";
    public static String DERIVEDEVENT_STORAGE_COLLECTION_PREFIX = "derived.";

    public static String SIMPLEEVENT_STORAGE_COLLECTION_NAME = "simple.system";
    public static String DERIVEDEVENT_STORAGE_COLLECTION_NAME = "derived.system";
    public static String PREDICTEDEVENT_STORAGE_COLLECTION_NAME = "predicted.system";
    public static String ANOMALYEVENT_STORAGE_COLLECTION_NAME = "anomaly.system";
    public static String RECOMMENDATIONEVENT_STORAGE_COLLECTION_NAME = "recommendation.system";
    public static String FEEDBACKEVENT_STORAGE_COLLECTION_NAME = "feedback.system";

    public static String REGISTRY_DATABASE_NAME = "proasense_registry";

    public static String STORAGE_DATABASE_NAME = "proasense_db";
    public static String STORAGE_SERIALIZED_EVENT_KEY = "SERIALIZED_EVENT";
    public static String STORAGE_HEARTBEAT = "STORAGE_HEARTBEAT";
}
