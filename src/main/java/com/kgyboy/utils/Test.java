package com.kgyboy.utils;

import com.kgyboy.rule.RegularRule;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

public class Test {
    public static void say(){
        BigDecimal a = new BigDecimal("1.01");
        System.out.println("测试"+a);
    }

    public static void main(String[] args) {
//        Map<String, Object> m = new HashMap<String, Object>();
//        m.put("a","");
//        m.put("b","123");
//        m.put("c",null);
//        m.put("d",45);
//        Set<String> keys1 = m.keySet();
//        for (String key: keys1) {
//            System.out.println(m.get(key));
//        }
//        System.out.println("===================");
//        Map<String, Object> map = MapUtils.dealNullVal(m);
//        Set<String> keys = map.keySet();
//        for (String key: keys) {
//            System.out.println(map.get(key));
//        }

//        System.out.println(RegularUtils.checkMobile("13912534568"));
//        System.out.println(RegularUtils.checkEmail("27@qq.com"));
//        System.out.println(RegularUtils.checkChinese("汉字"));
//        System.out.println(RegularUtils.checkIdcard("123456789104325"));
//        System.out.println(RegularUtils.checkIpAddr("255"));
//
//        System.out.println(RegularUtils.checkNumber("-789"));
//        System.out.println(RegularUtils.checkDecimal("-123.0"));
//        System.out.println(RegularUtils.checkContainNumber("无视0一二"));

//        String aa = "  ";
//        System.out.println(" ".equals(" "));
//        System.out.println(aa.replace(" ", "").isEmpty());

        System.out.println(NumberUtils.format("12.344",2));

        try {
            System.out.println(DateUtils.dateToStr(new Date(),DateUtils.YY_M_D_H_M_S));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
