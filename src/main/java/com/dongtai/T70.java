package com.dongtai;

import java.awt.datatransfer.Clipboard;

/**
 * @auther wuqiong
 * @date 2021/12/8
 * @time 15:45
 * @description 爬楼梯
 */
public class T70 {

    public static void main(String[] args) {
        System.out.println(new T70().climbStairs1(1));
        System.out.println(new T70().climbStairs(1));
    }


    /**
     * 动态规划    比如:  跑到第n层的楼梯  数量是n-1 + n-2  的和
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
       if (n==2){
           return 2;
       }
       if (n==3){
           return 3;
       }
       int n2 = 2;
       int n3 = 3;
       int x=0;
       for (int i = 4; i <= n; i++) {
               x = n2+n3;
               n2 = n3;
               n3 =x;

        }
        return x;

    }


    /**
     * 分治的算法,,这个是超出时间的限制了
     * @param n
     * @return
     */
    public int climbStairs1(int n) {

        if (n==0){
            return 1;
        }
        if (n<1){
            return 0;
        }

        int a = climbStairs1(n-1);
        int b = climbStairs1(n-2);

        return a+b;
    }



}

