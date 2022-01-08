package com.fuxi;

import com.LQB12.A;
import org.omg.PortableServer.POA;

import javax.swing.text.EditorKit;

/**
 * @auther wuqiong
 * @date 2022/1/7
 * @time 14:21
 * @description 冗余连接
 */
public class T684 {

    int[] parent ;
    int[] rank ;



    public int find(int x ){
        if (x==parent[x])return x;
        else {
            parent[x] = this.find(parent[x]);
        }

        return parent[x];
    }

    public void merge(int x ,int y){
        int a= find(x);
        int b =find(y);
        //找到之后判断是否在一颗树
        if (rank[a] < rank[b]){
            parent[a] = b;
        } else if (rank[a] > rank[b]) {
            parent[b] = a;
        }else {
            rank[b]+=1;
            parent[a]=b;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        parent= new int[edges.length+1];
        rank= new int[edges.length+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i]= i;
            rank[i]= 1;
        }
        for (int[] edge : edges) {
            int a1 = this.find(edge[0]);
            int a2 = this.find(edge[1]);
            if (a1==a2){
                return edge;
            }else {
                merge(edge[0],edge[1]);
            }
        }

        return new int[0];

    }
}
