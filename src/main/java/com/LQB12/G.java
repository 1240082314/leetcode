package com.LQB12;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @auther wuqiong
 * @date 2021/12/10
 * @time 15:35
 * @description
 */
public class G {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        long ms = in.nextLong();

        long hour_div = 60 * 60 * 1000;
        long min_div = 60 * 1000;

        // 保证小时在 [0, 23] 之内
        long hour = (ms / hour_div) % 24;
        ms %= hour_div;
        long min = ms / min_div;
        ms %= min_div;
        long sec = ms / 1000;

        System.out.printf("%02d:%02d:%02d\n", hour, min, sec);
        in.close();

    }
}