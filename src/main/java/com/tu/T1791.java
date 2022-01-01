package com.tu;

/**
 * @auther wuqiong
 * @date 2021/12/27
 * @time 15:32
 * @description 找出星型图的中心节点
 */
public class T1791 {


    public int findCenter1(int[][] edges) {

        // 要么首条 edge 第一个节点(edges[0][0])是交点，
        // 要么首边 edge 第二个节点(edge[0][1])是交点
        return (edges[0][0]==edges[1][0] || edges[0][0]==edges[1][1]) ? edges[0][0] : edges[0][1];
    }

    public int findCenter(int[][] edges) {
        int[] count = new int[edges.length + 1];
        for (int i = 0; i < count.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            count[x]++;
            count[y]++;
            if (count[x] == edges.length - 1 || count[y] == edges.length - 1) {
                return i;
            }
        }
        return -1;
    }

}
