package com.test;

import java.text.ParseException;
import java.util.Timer;

/**
 * @auther wuqiong
 * @date 2021/12/21
 * @time 15:55
 * @description
 */
public class Run {

    private static Timer timer=new Timer();

    public static void main(String[] args) throws ParseException
    {
        timer.schedule(new Mytask(), TimeUtil.df.get().parse("2017-09-14 09:19:30"));
    }
}