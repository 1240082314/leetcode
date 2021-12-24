package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @auther wuqiong
 * @date 2021/12/21
 * @time 15:53
 * @description
 */
public class TimeUtil {


        public static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {

            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
        };

}
