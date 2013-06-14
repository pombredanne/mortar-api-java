/*
 * Copyright 2013 Mortar Data Inc.
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
package com.mortardata.api.v2;

import com.google.api.client.util.Value;

/**
 * Status codes returned for Describe, Illustrate, and Validate
 */
public enum TaskStatus {

    /**
     * Submitted, pending execution.
     */
    @Value
    QUEUED("QUEUED"),

    /**
     * Pig server starting (happens on first request in session).
     */
    @Value
    GATEWAY_STARTING("GATEWAY_STARTING"),

    /**
     * Operation in progress.
     */
    @Value
    PROGRESS("PROGRESS"),

    /**
     * Syntax error in pigscript (details in error_message field)
     */
    @Value
    FAILURE("FAILURE"),

    /**
     * Operation complete; results available if applicable
     */
    @Value
    SUCCESS("SUCCESS"),

    /**
     * Operation terminated.
     */
    @Value
    KILLED("KILLED"),

    /**
     * Illustrate compiling plan for Pig script.
     */
    @Value("BUILDING_PLAN")
    ILLUSTRATE_BUILDING_PLAN("BUILDING_PLAN"),

    /**
     * Illustrate reading source data.
     */
    @Value("READING_DATA")
    ILLUSTRATE_READING_DATA("READING_DATA"),

    /**
     * Illustrate pruning data to minimal result set.
     */
    @Value("PRUNING_DATA")
    ILLUSTRATE_PRUNE_DATA("PRUNING_DATA"),

    /**
     * Illustrate post-processing of result data.
     */
    @Value("FINALIZE_RESULTS")
    ILLUSTRATE_FINALIZE_RESULTS("FINALIZE_RESULTS"),

    /**
     * Unrecognized status code.
     */
    UNKNOWN("UNKNOWN_STATUS");

    private String stringValue;

    /**
     * @param stringValue Mortar API compatible string value
     */
    TaskStatus(String stringValue) {
        this.stringValue = stringValue;
    }

    /**
     * Override toString to return stringValue
     *
     * @return Mortar API compatible string value
     */
    public String toString() {
        return stringValue;
    }

    /**
     * Get TaskStatus enum from stringValue
     *
     * @param value String value generated by the toString method
     * @return TaskStatus enum for the typeString value
     */
    public static TaskStatus getEnum(String value) {
        for (TaskStatus t : values()) {
            if (t.stringValue.equalsIgnoreCase(value)) {
                return t;
            }
        }
        return UNKNOWN;
    }


}
