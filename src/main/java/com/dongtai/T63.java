package com.dongtai;

/**
 * @auther wuqiong
 * @date 2022/1/3
 * @time 11:58
 * @description 不同路径
 */
public class T63 {

    public static void main(String[] args) {
        System.out.println(new T63().uniquePaths(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public int uniquePaths(int[][] obstacleGrid) {
        int m =obstacleGrid.length,n = obstacleGrid[0].length;
        int[][] f =new int[m][n];

        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0] == 1){
                f[i][0] = 0;
            }else {
                if (i>0){
                    f[i][0] = f[i-1][0];
                }else {
                    f[i][0] = 1;
                }

            }

        }
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j] == 1){
                f[0][j] = 0;
            }else {
                if (j>0){
                    f[0][j] = f[0][j-1];
                }else {
                    f[0][j] = 1;
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j]==1){
                    f[i][j]=0;
                }else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }

            }
        }

        System.out.println("开始");
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(f[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("结束");

        return f[m - 1][n - 1];
    }


    /**
     * 官方
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }



}
