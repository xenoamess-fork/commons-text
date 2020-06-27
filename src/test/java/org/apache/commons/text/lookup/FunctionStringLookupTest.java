/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */

package org.apache.commons.text.lookup;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link FunctionStringLookup}.
 */
public class FunctionStringLookupTest {

    @Test
    public void testConcurrentHashMapNull() {
        final Map<String, Object> map = new ConcurrentHashMap<>();
        Assertions.assertNull(FunctionStringLookup.on(k -> map.get(k)).lookup(null));
    }

    @Test
    public void testHashMapNull() {
        final Map<String, Object> map = new HashMap<>();
        Assertions.assertNull(FunctionStringLookup.on(k -> map.get(k)).lookup(null));
    }

    @Test
    public void testOne() {
        final String key = "key";
        final String value = "value";
        final Map<String, String> map = new HashMap<>();
        map.put(key, value);
        Assertions.assertEquals(value, FunctionStringLookup.on(k -> map.get(k)).lookup(key));
    }

}