package com.yg.utils;

import java.text.SimpleDateFormat;

public class DateUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //1.字符串转util.Date
    public static java.util.Date strToUtil(String str) {
        try {
            java.util.Date date = sdf.parse(str);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //2.util.Date转字符串
    public static String utilToStr(java.util.Date date) {

        return sdf.format(date);
    }

    //3.util.Date转sql.Date
    public static java.sql.Date utilToSql(java.util.Date date) {
        if (date == null){
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

}
