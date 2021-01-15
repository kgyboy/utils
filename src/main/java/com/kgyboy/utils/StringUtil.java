package com.kgyboy.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgyboy.rule.RegularRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @ClassName StringUtil
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2021/1/15
 */
public class StringUtil {

    /**
     * 判断是否不为空
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断是否为空
     */
    public static boolean isBlank(String str) {
        return null == str || "null".equalsIgnoreCase(str) || str.replace(" ", "").isEmpty();
    }

    /**
     * 正则截取字符串
     */
    public static List<String> regexSubstr(String str, char start, char end) {

        List<String> list = new ArrayList<>();
        String reg = String.format("\\%s.*?\\%s", start, end);
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group().replace(start + "", "").replace(end + "", ""));
        }
        return list;
    }

    /**
     * 字符串根据转任意类
     */

    public static Object conver(Object value, Class<?> toValueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(value, toValueType);
    }

    /**
     * 筛选数字或者筛选非数字
     * 1008非数字；1009数字
     */
    public static String filterNumber(String str, int code) {
        Pattern p = Pattern.compile(Objects.requireNonNull(RegularRule.getReg(code)));
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }

}
