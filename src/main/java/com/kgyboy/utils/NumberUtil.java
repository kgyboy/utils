package com.kgyboy.utils;

import java.text.DecimalFormat;

/**
 *
 * @ClassName NumberUtil
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2021/1/15
 */
public class NumberUtil {

    public static Double format(Double tmp,int digits) {
        StringBuilder pattern = new StringBuilder("#.");
        for (int i = 0; i < digits; i++) {
            pattern.append("#");
        }
        try {
            DecimalFormat df = new DecimalFormat(pattern.toString());
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
