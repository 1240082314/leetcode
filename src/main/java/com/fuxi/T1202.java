package com.fuxi;

import com.LQB11.H;
import sun.misc.ObjectInputFilter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @auther wuqiong
 * @date 2022/1/6
 * @time 14:28
 * @description 交换字符串中的元素
 *
 *  并查集
 */
public class T1202 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size()==0){
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;

        //合并并查集
        for (int i = 0; i < pairs.size(); i++) {
            int a1= pairs.get(i).get(0);
            int a2= pairs.get(i).get(1);
            this.merge(a1,a2);
        }

        HashMap<Integer,PriorityQueue<Character>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            //找到根节点
            int root = this.find(i);

            //然后看看有没有此键
            if (map.containsKey(root)){
                map.get(root).offer(chars[i]);
            }else {
                PriorityQueue<Character> queue = new PriorityQueue<>();
                queue.offer(chars[i]);
                map.put(root,queue);
            }
        }
        //最后就是找出所有的数值
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = this.find(i);
            stringBuilder.append(map.get(root).poll());
        }
        return stringBuilder.toString();



    }

    //并查集

    int[] parent = new int[27];//分别是1-27 的a b c d……
    int[] rank = new int[27];//分别是1-27 的a b c d……

    //初始化
    {
        for (int i = 0; i < 27; i++) {
            parent[i]=i;
            //这个代表深度的
            rank[i] = 1;
        }


    }

    //最终的寻找找到这颗树的最高节点
    public int find(int i){
        if ( i == parent[i]){
            return i;
        }else {
            //这个优化后的寻找，，从而减少了寻找的次数
            parent[i] = find(parent[i]);  //父节点设为根节点
            return parent[i];         //返回父节点
        }
    }

    //
    public void merge(int i ,int j ){

        int x = find(i), y = find(j);    //先找到两个根节点
        if (rank[x] <= rank[y])
            parent[x] = y;
        else
            parent[y] = x;

        if (rank[x] == rank[y] && x != y)
            rank[y]++;

    }




}
