/*
 * Copyright 2011 SpringSource.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Collection utility methods.
 *
 * @author Burt Beckwith
 */
public class CollectionUtils {

    private CollectionUtils() {
        // static only
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <K, V> Map newMap(Object... keysAndValues) {
        if (keysAndValues == null) {
            return Collections.emptyMap();
        }
        if (keysAndValues.length % 2 == 1) {
            throw new IllegalArgumentException("Must have an even number of keys and values");
        }

        Map<K, V> map = new HashMap<K, V>();
        for (int i = 0; i < keysAndValues.length; i += 2) {
            map.put((K)keysAndValues[i], (V)keysAndValues[i + 1]);
        }
        return map;
    }

    public static <T> Set<T> newSet(T... values) {
        if (values == null) {
            return Collections.emptySet();
        }

        return new HashSet<T>(Arrays.asList(values));
    }

    public static <T> List<T> newList(T... values) {
        if (values == null) {
            return Collections.emptyList();
        }

        return new ArrayList<T>(Arrays.asList(values));
    }
}
