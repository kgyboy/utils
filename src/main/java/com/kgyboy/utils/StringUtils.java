package com.kgyboy.utils;

/**
 * author yang
 * time 2019-01-25
 */
public class StringUtils {

    /**
     * 判断是否不为空
     */
    public static boolean isNotBlank(String str) {
        if (isBlank(str)) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否为空
     */
    public static boolean isBlank(String str) {
        if (null == str || str.replace(" ","").isEmpty()) {
            return true;
        }

//        if ("null".equals(str)) {
//            return true;
//        }
        return false;
    }

}
