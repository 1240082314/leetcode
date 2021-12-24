package com.shijian;

import com.LQB12.A;
import sun.util.resources.LocaleData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.TimeZone;
import java.util.logging.SimpleFormatter;

/**
 * @auther wuqiong
 * @date 2021/12/21
 * @time 15:23
 * @description  一年中的第几天
 */
public class T1154 {

    public int dayOfYear1(String date) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar instance = Calendar.getInstance();
//        Date parse = null;
//        try {
//            parse = simpleDateFormat.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        instance.setTime(parse);
//        System.out.println(parse.getDate());//1
//        System.out.println(parse.getYear());
//        System.out.println(parse.getMonth());
//        System.out.println(parse.getDay());
//        System.out.println(date);
//        System.out.println(2019-1970);
        LocalDate of = LocalDate.of(Integer.parseInt(date.substring(0,4)),Integer.parseInt(date.substring(5,7)),Integer.parseInt(date.substring(8,10)));
        return of.getDayOfYear();
    }

    public static void main(String[] args) throws ParseException {

        System.out.println(new T1154().dayOfYear1("2019-03-01"));
        System.out.println("-----------------");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String da = "2019-3-1";

        LocalDate of = LocalDate.of(2021, 3, 1);
        System.out.println(of.getDayOfYear());
        System.out.println(of.getDayOfMonth());
//        System.out.println(of.get());
        Calendar calendar  = new GregorianCalendar();
        Date date3 = simpleDateFormat.parse("2019-3-1");
        calendar.setTime(date3);
//        calendar.get

//        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println();


        //个人解答
        //---------------------------------------------------------------------
//
        Date date = new Date();//Tue Dec 21 15:34:00 CST 2021
        Date date1 = new Date(1000L);//Thu Jan 01 08:00:01 CST 1970
        Date date2 = new Date(System.currentTimeMillis());//Tue Dec 21 15:34:00 CST 2021
        System.out.println(date.toGMTString());
//        System.out.println(date1);
//        System.out.println(date2);
//
//        System.out.println(simpleDateFormat.format(date));


//        Calendar calendar = new GregorianCalendar();
//
//
//
//        // 设置日历时间
//        calendar.set(Calendar.YEAR, 2019);
//        calendar.set(Calendar.MONTH, 5);
//        calendar.set(Calendar.DAY_OF_MONTH, 26);
//
//        //使用Date类设置calendar时间
        calendar.setTime(new Date());
//
//        //取得日历时间 calendar.getTime();  返回一个Date对象
//        // 输出Wed Jun 26 12:58:42 CST 2019
//        System.out.println(simpleDateFormat.format(calendar.getTime()));
//
////使用日历取得时间偏移
//// 输出Tue Jun 26 12:58:42 CST 2029
//        calendar.add(Calendar.YEAR, 10);
//        System.out.println(simpleDateFormat.format(calendar.getTime()));
//// LocalTime 包含具体时间
//        LocalTime localTime = LocalTime.of(22, 10, 59);
//        System.out.println("localTime = " + localTime);

        // 本地日期
        LocalDate localDate = LocalDate.of(2019, 2, 14);
//        System.out.println(localDate);
//        int year = localDate.getYear(); //那一年
//        System.out.println("year = " + year);
//        Month month = localDate.getMonth(); // 第几个月
//        System.out.println("month = " + month);
//        int dayOfMonth = localDate.getDayOfMonth(); //一个月的第几天
//        System.out.println("dayOfMonth = " + dayOfMonth);
//        DayOfWeek dayOfWeek = localDate.getDayOfWeek(); //一周的第几天
//        System.out.println("dayOfWeek = " + dayOfWeek);
//        int lenth = localDate.lengthOfMonth(); // 一个月的天数
//        System.out.println("lenth = " + lenth);
//        boolean leapYear = localDate.isLeapYear(); // 是否是闰年
//        System.out.println("leapYear = " + leapYear);
//
////获取当前日期
//        System.out.println("LocalDate.now() = " + LocalDate.now());
//
//
//        // 一个时间戳
//        Instant instant = Instant.now();
//        System.out.println("instant = " + instant);
//        System.out.println("-----------------");
//        // 时间加减操作
        LocalDate date1111 = LocalDate.now();
//        LocalDate localDate2 = date.minusDays(5);
//        LocalDate localDate3 = date.plusYears(10);
//        date.plus(5, ChronoUnit.DAYS);
//        System.out.println("localDate3 = " + localDate3);
//        System.out.println("localDate2 = " + localDate2);
//        System.out.println("localDate = " + date);

    }


    /**
     * 官方解答
     * @param date
     * @return 2020
     */
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //先计算出来年份的情况  然后天数就是和月份和day相关
        //如果是闰年的话   -> 2月份就是29天   条件-> 4的倍数切不是100的倍数 或者是 400的倍数可以
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            ++amount[1];
        }

        int ans = 0;
        for (int i = 0; i < month - 1; ++i) {
            ans += amount[i];
        }
        return ans + day;
    }

}
