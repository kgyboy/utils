package com.kgyboy.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * author yang
 * time 2019-01-25
 */
public class MapUtils {
    public static Map<String, Object> dealNullVal(Map<String, Object> map){
        Map<String, Object> m = new HashMap<String, Object>();
        Set<String> keys = map.keySet();
        for (String key: keys) {
            String val = (String) (map.get(key)+"");
            if (StringUtils.isNotBlank(val))
                m.put(key,val);
        }
        return m;
    }
}
