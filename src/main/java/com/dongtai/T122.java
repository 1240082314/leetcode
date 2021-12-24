package com.dongtai;

/**
 * @auther wuqiong
 * @date 2021/12/8
 * @time 16:09
 * @description  买卖股票的最佳时机II
 */
public class T122 {

    public static void main(String[] args) {
        new T122().maxProfit(new int[]{    7,1,5,3,6,4  });
    }


    public int maxProfit(int[] prices) {
//        用一个二维数组来记录
        int n = prices.length;
        int[][] dp = new int[n][2]; //其中第一列代表的是卖出去，第二类代表的是买回来
        //那么默认第天就是收入为0
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            //这个就是卖出去股票    比较
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //这个就是买进来股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];


    }
    /**
     * 贪心算法
     */
    public int maxProfit1(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
