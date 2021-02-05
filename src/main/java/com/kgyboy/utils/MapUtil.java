package com.kgyboy.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @ClassName MapUtil
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2021/1/15
 */
public class MapUtil {

    /**
     * 未改变源数据map
     * @param map
     * @return
     */
    public static Map<String, Object> dealNullValUnchanged(Map<String, Object> map) {
        Map<String, Object> m = new HashMap<>();
        for (String key : map.keySet()) {
            String val = (String) map.get(key);
            if (StringUtil.isNotBlank(val)) {
                m.put(key, val);
            }
        }
        return m;
    }

    /**
     * 改变源数据map
     * @param map
     * @return
     */
    public static Map<String, Object> dealNullValChanged(Map<String, Object> map) {
        Iterator var2 = map.keySet().iterator();
        while(var2.hasNext()) {
            String key = (String)var2.next();
            if (StringUtil.isBlank((String) map.get(key))) {
                map.remove(key);
                var2 = map.keySet().iterator();
            }
        }
        return map;
    }
}
