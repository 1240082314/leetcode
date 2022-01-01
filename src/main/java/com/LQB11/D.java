package com.LQB11;

import java.util.ArrayList;
import java.util.HashSet;
/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 16:29
 * @description 七段代
 */


public class D {


    //这个图就全部
    static ArrayList<Integer>[] list;

    //这个是存储路径的
    static HashSet<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) {
        init();

        for(int i=0; i<7; ++i) {
            //0已经访问过，做一下标记
            vis[0] = i;
            //扩大i倍数  -> 1 2 4 8 16
            set.add(1<<i);
            dfs(1, 1<<i);
        }

        System.out.println(set.size());
    }

    //判断是否访问
    static int[] vis = new int[7];
    //从n点 到 v点的路径
    public static void dfs(int n, int v) {
        for(int i=0; i<n; ++i) {
            //以i为起始点
            for(int t : list[vis[i]]) {
                //1/2 | v
                int p = v | (1<<t);
                if(!set.contains(p)) {
                    set.add(p);
                    vis[n] = t;
                    dfs(n+1, p);
                }
            }
        }
    }

    /**
     *    		0
     *  	5    	1
     *  		6
     *  	4		2
     *  		3
     */

    //所以这是图的  连接表示法
    public static void init() {
        //七个点
        list = new ArrayList[7];
        //每个点链接的点
        for(int i=0; i<7; ++i) {
            list[i] = new ArrayList<Integer>();
        }

        list[0].add(1);
        list[0].add(5);

        list[1].add(0);
        list[1].add(6);
        list[1].add(2);

        list[2].add(1);
        list[2].add(3);
        list[2].add(6);

        list[3].add(2);
        list[3].add(4);

        list[4].add(3);
        list[4].add(5);
        list[4].add(6);

        list[5].add(0);
        list[5].add(4);
        list[5].add(6);

        list[6].add(1);
        list[6].add(2);
        list[6].add(4);
        list[6].add(5);
    }

}

