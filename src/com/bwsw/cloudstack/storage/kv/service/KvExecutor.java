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

package com.bwsw.cloudstack.storage.kv.service;

import com.bwsw.cloudstack.storage.kv.entity.CreateStorageRequest;
import com.bwsw.cloudstack.storage.kv.entity.DeleteStorageRequest;
import com.bwsw.cloudstack.storage.kv.entity.ResponseEntity;
import com.bwsw.cloudstack.storage.kv.entity.ScrollableListResponse;
import org.apache.cloudstack.api.response.ListResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public interface KvExecutor {

    <T extends ResponseEntity> T get(RestHighLevelClient client, GetRequest request, Class<T> elementClass) throws IOException;

    void index(RestHighLevelClient client, IndexRequest request) throws IOException;

    void update(RestHighLevelClient client, UpdateRequest request) throws IOException;

    <T extends ResponseEntity> ListResponse<T> search(RestHighLevelClient client, SearchRequest request, Class<T> elementClass) throws IOException;

    <T extends ResponseEntity> ScrollableListResponse<T> scroll(RestHighLevelClient client, SearchRequest request, Class<T> elementClass) throws IOException;

    <T extends ResponseEntity> ScrollableListResponse<T> scroll(RestHighLevelClient client, SearchScrollRequest request, Class<T> elementClass) throws IOException;

    void create(RestHighLevelClient client, CreateStorageRequest request) throws IOException;

    boolean delete(RestHighLevelClient client, DeleteStorageRequest request) throws IOException;
}
