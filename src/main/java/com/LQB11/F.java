package com.LQB11;

import java.util.Scanner;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 16:56
 * @description 成绩分析
 */
public class F {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double sum = 0;
        for(int i=0; i<n; ++i) {
            int t = sc.nextInt();
            sum += t;
            max = t>max?t:max;
            min = t<min?t:min;
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(String.format("%.2f", sum/n));
    }

}
