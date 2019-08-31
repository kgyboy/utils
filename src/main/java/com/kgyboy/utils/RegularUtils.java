package com.kgyboy.utils;

import com.kgyboy.rule.RegularRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author yang
 * time 2019-01-25
 */
public class RegularUtils {

    /**
     * 判断是否是正确手机号
     */
    public static boolean checkMobile(String str) {
        return Pattern.matches(RegularRule.getReg(1001), str);
    }
    /**
     * 判断是否是正确邮箱
     */
    public static boolean checkEmail(String str) {
        return Pattern.matches(RegularRule.getReg(1002), str);
    }
    /**
     * 判断是否是汉字
     */
    public static boolean checkChinese(String str) {
        return Pattern.matches(RegularRule.getReg(1003), str);
    }
    /**
     * 判断是否是正确身份证
     */
    public static boolean checkIdcard(String str) {
        return Pattern.matches(RegularRule.getReg(1004), str);
    }
    /**
     * 判断是否是正确Ip
     */
    public static boolean checkIpAddr(String str) {
        return Pattern.matches(RegularRule.getReg(1005), str);
    }
    /**
     * 判断是否是整数
     */
    public static boolean checkNumber(String str) {
        return Pattern.matches(RegularRule.getReg(1006), str);
    }
    /**
     * 判断是否是小数
     */
    public static boolean checkDecimal(String str) {
        return Pattern.matches(RegularRule.getReg(1007), str);
    }
    /**
     * 判断是否包含数字
     */
    public static boolean checkContainNumber(String str) {

        Pattern p = Pattern.compile(RegularRule.getReg(1008));
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

}
