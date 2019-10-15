package com.kgyboy.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (null == str || str.replace(" ", "").isEmpty()) {
            return true;
        }

//        if ("null".equals(str)) {
//            return true;
//        }
        return false;
    }

    /**
     * 正则截取字符串
     */
    public static List<String> regexSubstr(String str, char start, char end) {
        List<String> list = new ArrayList<>();
        String regex = "\\" + start + "[^\\" + end + "]+\\" + end;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group().replace(start + "", "").replace(end + "", ""));
        }
        return list;
    }

}
