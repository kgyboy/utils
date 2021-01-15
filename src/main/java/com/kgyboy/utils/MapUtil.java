package com.kgyboy.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @ClassName MapUtil
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2021/1/15
 */
public class MapUtil {

    public static Map<String, Object> dealNullVal(Map<String, Object> map) {
        Map<String, Object> m = new HashMap<>();
        for (String key : map.keySet()) {
            String val = (String) map.get(key);
            if (StringUtil.isNotBlank(val)) {
                m.put(key, val);
            }
        }
        return m;
    }
}
