package com.kgyboy.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @ClassName DateUtil
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2021/1/15
 */

public class DateUtil {
    public static final String Y = "yyyy";
    public static final String M = "MM";
    public static final String D = "dd";
    public static final String H = "HH";
    public static final String m = "mm";
    public static final String S = "ss";
    public static final String YMD = "yyyyMMdd";
    public static final String YYMDHMS = "yyyyMMddHHmmss";
    public static final String HMS = "HH:mm:ss";
    public static final String Y_M_D = "yyyy-MM-dd";
    public static final String Y_M_D_H_M = "yyyy-MM-dd HH:mm";
    public static final String YY_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
    public static final String YY_M_D_H_M_S_S = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String Y__M__D = "yyyy/MM/dd";
    public static final String Y__M__D_H_M_S = "yyyy/MM/dd HH:mm:ss";
    public static final String C_Y_M_D = "yyyy年MM月dd日";
    public static final String C_Y_M_D_H_M_S = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * @description 计算两个时间相差毫秒数
     * @param date1 日期1
     * @param date2 日期2
     * @return long 毫秒
     */
    public static long twoDateDiff(Date date1, Date date2){
        return date1.getTime() - date2.getTime();
    }

    /**
     * @description 计算日期n天后的日期
     * @param date 日期
     * @param days 正数为days天后，负数为days天前
     * @return Date
     */
    public static Date dateAddDays(Date date,int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);//把日期往后增加一天.整数往后推,负数往前移动

        return calendar.getTime();
    }

    /**
     * @description 字符串日期->Date日期
     * @param dateStr 字符串日期
     * @param format 正则 eg:yyyy-MM-dd HH:mm:ss
     * @return Date
     * @throws ParseException
     */
    public static Date strToDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(dateStr);
    }

    /**
     * @description Date日期->字符串日期，线程非安全
     * @param date 日期
     * @param format 正则 eg:yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String dateToStr(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * 时间格式为yyyy-MM-dd HH:mm:ss的date1和date2作差，毫秒数大于mills 返回true
     * @param date1
     * @param date2
     * @param mills
     * @return
     * @throws ParseException
     */
    public static boolean dateCompare(String date1,String date2,long mills) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = df.parse(date1);
        Date d2 = df.parse(date2);

        return new BigDecimal(d1.getTime()).subtract(new BigDecimal(d2.getTime())).compareTo(new BigDecimal(mills))>-1;
    }

    /**
     * 根据day_of_week返回星期字段
     * @param seq
     * @return
     */
    public static String getWeekDay(int seq) {
        StringBuilder week = new StringBuilder();
        switch (seq) {
            case 1:
                week.append("星期日");
                break;
            case 2:
                week.append("星期一");
                break;
            case 3:
                week.append("星期二");
                break;
            case 4:
                week.append("星期三");
                break;
            case 5:
                week.append("星期四");
                break;
            case 6:
                week.append("星期五");
                break;
            case 7:
                week.append("星期六");
                break;
            default:
                week.append("未知");
                break;
        }
        return week.toString();
    }

    /**
     * @description 字符串日期->LocalDateTime日期
     * @param localDateTime 字符串日期
     * @param format 正则 eg:yyyy-MM-dd HH:mm:ss
     * @return LocalDateTime
     */
    public static LocalDateTime strToLocalDateTime(String localDateTime, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(localDateTime, formatter);
    }

    /**
     * @description LocalDateTime日期->字符串日期，线程安全
     * @param localDateTime 日期
     * @param format 正则 eg:yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String localDateTimeToStr(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(localDateTime);
    }

    /**
     * @description 计算日期n天后的日期
     * @param localDateTime 日期
     * @param days 正数为days天后，负数为days天前
     * @return Date
     */
    public static LocalDateTime localDateTimeAddDays(LocalDateTime localDateTime,long days){
        return localDateTime.plus(days, ChronoUnit.DAYS);
    }

    /**
     * @description 计算日期n天后的日期
     * @param localDate 日期
     * @param days 正数为days天后，负数为days天前
     * @return Date
     */
    public static LocalDate localDateAddDays(LocalDate localDate, long days){
        return localDate.plus(days, ChronoUnit.DAYS);
    }



}
