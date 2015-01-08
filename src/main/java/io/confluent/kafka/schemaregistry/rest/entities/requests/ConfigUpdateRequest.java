/*
 * Copyright 2014 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.confluent.kafka.schemaregistry.rest.entities.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import io.confluent.kafka.schemaregistry.avro.AvroCompatibilityLevel;

public class ConfigUpdateRequest {

  private AvroCompatibilityLevel compatibilityLevel;

  public static ConfigUpdateRequest fromJson(String json) throws IOException {
    return new ObjectMapper().readValue(json, ConfigUpdateRequest.class);
  }

  @JsonProperty("compatibility")
  public AvroCompatibilityLevel getCompatibilityLevel() {
    return this.compatibilityLevel;
  }

  @JsonProperty("compatibility")
  public void setCompatibilityLevel(AvroCompatibilityLevel compatibilityLevel) {
    this.compatibilityLevel = compatibilityLevel;
  }

  public String toJson() throws IOException {
    return new ObjectMapper().writeValueAsString(this);
  }
}
