package com.dongtai;

/**
 * @auther wuqiong
 * @date 2022/1/3
 * @time 11:42
 * @description  62. 不同路径
 */
public class T62 {


    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] f =new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }


    /**
     * 这个是 排列的组合
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }


}
