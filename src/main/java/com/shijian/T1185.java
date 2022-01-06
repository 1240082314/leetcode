package com.shijian;

import com.tanxin.T11;

/**
 * @auther wuqiong
 * @date 2022/1/3
 * @time 10:32
 * @description 一周中的第几天
 */
public class T1185 {

    public static void main(String[] args) {
        System.out.println(new T1185().dayOfTheWeek(31, 8, 2019));
        System.out.println(new T1185().dayOfTheWeek1(31, 8, 2019));

        System.out.println(new T1185().dayOfTheWeek(18, 7, 1999));
        System.out.println(new T1185().dayOfTheWeek1(18, 7, 1999));

        System.out.println(new T1185().dayOfTheWeek(15, 8, 1993));
        System.out.println(new T1185().dayOfTheWeek1(15, 8, 1993));




    }


    String[] days =  new String[]{ "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};

    int [] weeks = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

    public String dayOfTheWeek(int day, int month, int year) {
        //1970 年 1212 月 3131 日  是星期四
        // yuer 年 month 月 day 日
        //如果是普通的年份则->
        int sum = 0;
//        for (int week : weeks) {
//            sum += week;
//        }
//        System.out.println(sum);
        //天数该怎么计算？

        int count = 365 * (year-1971);
        //这个是年份
        System.out.println(count+"<<<<<<<<<<<<<<<-");
        for (int i = 1971; i < year; i++) {
            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                //说明是润年
                count += 1;
            }
        }
        System.out.println(count+"<<<<<<<<<<<<<<<-");
//        这个是月份
        for (int i = 0; i < month-1; i++) {
            count += weeks[i];
        }
        System.out.println(count+"<<<<<<<<<<<<<<<-");
//        这个是如果是闰年的闰月
//        year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3
        if (( year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month > 2) {
            //说明是润年
            count += 1;
        }
        System.out.println(count+"<<<<<<<<<<<<<<<-");
//        这个是加入最后的day天数
        count += day;

        return days[(count+3)%7];

    }




    /**
     * 官方解答
     * @param day
     * @param month
     * @param year
     * @return
     */
    public String dayOfTheWeek1(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* 输入年份之前的年份的天数贡献 */
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* 输入年份中，输入月份之前的月份的天数贡献 */
        System.out.println(days+"->>>>>>>>>>>");
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        System.out.println(days+"->>>>>>>>>>>");
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        System.out.println(days+"->>>>>>>>>>>");
        /* 输入月份中的天数贡献 */
        days += day;
//        System.out.println(1969/4);
//        System.out.println(1972%4);
        return week[(days + 3) % 7];

    }



}
