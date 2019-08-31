package com.kgyboy.utils;

import java.text.DecimalFormat;

public class NumberUtils {

    public static Double format(Double tmp,int digits) {
        String pattern = "#.";
        for (int i = 0; i < digits; i++) {
            pattern += "#";
        }
        try {
            DecimalFormat df = new DecimalFormat(pattern);
            String s = df.format(tmp);
            return Double.parseDouble(s);
        } catch (Exception e) {
            return tmp;
        }
    }

    public static String format(String tmp,int digits) {
        Double d = format(Double.parseDouble(tmp), digits);
        return d.toString();
    }
}
