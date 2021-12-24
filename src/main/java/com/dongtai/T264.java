package com.dongtai;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther wuqiong
 * @date 2021/12/9
 * @time 15:18
 * @description 丑数
 */
public class T264 {


    public int nthUglyNumber(int n) {
//        第一个丑数是[1, 2, 3, 4, 5, 6, 8, 9, 10, 12]
        //[2,3,5]

        int[] arr = new int[n + 1];
        int p1 = 1, p2 = 1, p3 = 1;
        arr[1] = 1;


        for (int i = 2; i <= n; i++) {

            int num1 = arr[p1] * 2;
            int num2 = arr[p2] * 3;
            int num3 = arr[p3] * 5;
            arr[i] = Math.min(Math.min(num1, num2), num3);
            if (arr[i] == num1) {
                p1++;
            }
            if (arr[i] == num2) {
                p2++;
            }
            if (arr[i] == num3) {
                p3++;
            }

        }
        return arr[n];


    }

    public int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }


}
