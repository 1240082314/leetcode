package com.shijian;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @auther wuqiong
 * @date 2021/12/21
 * @time 16:43
 * @description
 */
public class Test2 {
    public static void main(String[] args) {

        // Creating calendar object
        Calendar calndr = Calendar.getInstance();

        // Displaying the current time zone
        String tz_name = calndr.getTimeZone()
                .getDisplayName();

        System.out.println("The Current Time"
                + " Zone: " + tz_name);

        TimeZone time_zone
                = TimeZone.getTimeZone("GMT");

        // Modifying the time zone
        calndr.setTimeZone(time_zone);

        // Displaying the modified zone
        System.out.println("Modified Zone: "
                + calndr.getTimeZone()
                .getDisplayName());
    }
}
