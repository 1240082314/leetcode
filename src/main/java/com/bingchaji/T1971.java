package com.bingchaji;

/**
 * @auther wuqiong
 * @date 2021/12/27
 * @time 15:47
 * @description 寻找图中是否存在路径
 */
public class T1971 {

//    //  寻找的是  那个有效的路径 可以才用深度遍历的方式
//    public boolean validPath(int n, int[][] edges, int start, int end) {
//
//    }

//------------------并查集----------------------
    int[] parent;
    int size ;

    public T1971(int size) {
        this.size = size;
        parent = new int[size];
        for (int i =0;i<parent.length;i++){
            parent[i] =i;
        }
    }
    /**
     * 1,find
     * 2,isConnected
     * 3,merge
     */
    public int find(int a){
        int b = parent[a];
        if (b!=a){
            return find(b);
//            return parent[a]=find(b); 这个是路径压缩的方法
        }
        return b;
    }

    //判断是否再一棵子树上
    public boolean isConnected(int a,int b ){
        return find(a) == find(b);
    }

    public void merge(int a,int b){
        int c = find(a);
        int d = find(b);
        //说明在一棵子树上
        if (c==d){
            return;
        }
        parent[c]=d;
    }



    //    来解决问题（并查集）
    public boolean validPath1(int n, int[][] edges, int start, int end) {
        for (int i = 0; i < edges.length; i++) {
            this.merge(edges[i][0], edges[i][1]);
        }
        return this.isConnected(start,end);


    }
}
