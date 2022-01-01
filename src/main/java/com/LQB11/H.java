package com.LQB11;

import java.util.Scanner;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 17:01
 * @description 数字三角形
 */
public class H {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] r = new int[n+1][n+1];

        for(int i=1; i<=n; ++i) {
            for (int j = 1; j <= i; ++j) {
                r[i][j] = sc.nextInt();
                r[i][j] += Math.max(r[i - 1][j - 1], r[i - 1][j]);
            }
        }

        System.out.println(n%2==1?r[n][n/2+1]:Math.max(r[n][n/2], r[n][n/2+1]));
    }

}
