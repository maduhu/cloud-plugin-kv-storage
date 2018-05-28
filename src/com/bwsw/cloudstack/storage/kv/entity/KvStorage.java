// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.bwsw.cloudstack.storage.kv.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KvStorage {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public enum KvStorageType {
        ACCOUNT, VM, TEMP
    }

    @JsonIgnore
    private String id;
    private KvStorageType type;
    private String account;
    private String name;
    private String description;
    private Integer ttl;
    private Long expirationTimestamp;

    public KvStorage() {
    }

    public KvStorage(String id) {
        this.id = id;
        this.type = KvStorageType.VM;
    }

    public KvStorage(String id, String account, String name, String description) {
        this.id = id;
        this.type = KvStorageType.ACCOUNT;
        this.account = account;
        this.name = name;
        this.description = description;
    }

    public KvStorage(String id, Integer ttl, Long expirationTimestamp) {
        this.id = id;
        this.type = KvStorageType.TEMP;
        this.ttl = ttl;
        this.expirationTimestamp = expirationTimestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KvStorageType getType() {
        return type;
    }

    public void setType(KvStorageType type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    @JsonProperty("expiration_timestamp")
    public Long getExpirationTimestamp() {
        return expirationTimestamp;
    }

    public void setExpirationTimestamp(Long expirationTimestamp) {
        this.expirationTimestamp = expirationTimestamp;
    }
}