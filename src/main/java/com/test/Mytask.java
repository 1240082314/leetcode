package com.test;

import java.text.DateFormat;

import java.util.Date;

import java.util.TimerTask;

/**
 * @auther wuqiong
 * @date 2021/12/21
 * @time 15:51
 * @description
 */
public class Mytask extends TimerTask {


    //这个是需要执行的任务
    @Override
    public void run()
    {

        //这个是时间的格式化类
        DateFormat dateFormat = TimeUtil.df.get();
        //  执行任务的当前时间
        System.out.println("我的任务运行了" + dateFormat.format(new Date()));
    }

}







