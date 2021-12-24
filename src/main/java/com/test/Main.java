package com.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @auther wuqiong
 * @date 2021/12/21
 * @time 16:02
 * @description
 */
public class Main {

    public static void main(String[] args) {
//      一次
//           public void schedule(TimerTask task, long delay);
//           public void schedule(TimerTask task, Date time);

           //循环执行
           // 在循环执行类别中根据循环时间间隔又可以分为两类
//           public void schedule(TimerTask task, long delay, long period) ;
//            public void schedule(TimerTask task, Date firstTime, long period) ;


//        public void scheduleAtFixedRate(TimerTask task, long delay, long period)
//             public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period)

        Timer timer = new Timer();

             //延迟1000ms执行程序
             timer.schedule(new TimerTask() {
               @Override
                    public void run() {
                                   System.out.println("IMP1 当前时间" + this.scheduledExecutionTime());
                               }
            }, 1000);
              //延迟10000ms执行程序
              timer.schedule(new TimerTask() {
            @Override
            public void run() {
                            System.out.println("IMP2 当前时间" + this.scheduledExecutionTime());
                          }
        }, new Date(System.currentTimeMillis() + 10000));


              //-------------------------


        //前一次执行程序结束后 2000ms 后开始执行下一次程序
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP11 当前时间" + this.scheduledExecutionTime());
            }
        }, 10000,2000);

//        //前一次程序执行开始 后 2000ms后开始执行下一次程序
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("IMP22 当前时间" + this.scheduledExecutionTime());
//            }
//        },0,2000);

    }


}
