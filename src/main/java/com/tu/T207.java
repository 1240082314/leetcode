package com.tu;

import javax.swing.text.StyledEditorKit;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @auther wuqiong
 * @date 2022/1/1
 * @time 10:27
 * @description  课程表I
 */
public class T207 {


    /**
     * 深度优先遍历 + 栈的方式
     */
    
    List<List<Integer>> edges;//用来存储这个节点后面的节点
    int[] visited;  //判断此节点是否被访问  0代表的是没有被访问的  ， 1 代表的是已经被访问的   2，代表的是
    boolean valid  = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1.初始化edges
        edges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
           edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
//        2.深度遍历
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0 ){//说明是没有被访问的
                dfs(i);
            }
        }
        return valid;
        
    }

    //这个是深度遍历的方法
    private void dfs(int i) {
        //1.修改已经访问过的情况
        visited[i] = 1;
        for (int v :
                edges.get(i)) {
            //v全部都是存储在她后面的数值 ，所以这个时候需要dfs
            if (visited[v] == 0) {
                dfs(v);
                //判断一下是否结束
                if (!valid) {
                    return;
                }
                //如果已经被访问了，  说明直接返回false
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }

    //------------------------------------------------------------------
//    List<List<Integer>> edges;
//    int[] visited;
//    boolean valid = true;
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        edges = new ArrayList<List<Integer>>();
//
//        for (int i = 0; i < numCourses; ++i) {
//            edges.add(new ArrayList<Integer>());
//        }
//
//        visited = new int[numCourses];
//        for (int[] info : prerequisites) {
//            edges.get(info[1]).add(info[0]);
//        }
//
//        for (int i = 0; i < numCourses && valid; ++i) {
//            if (visited[i] == 0) {
//                dfs(i);
//            }
//        }
//        return valid;
//    }
//
//    public void dfs(int u) {
//        visited[u] = 1;
//        for (int v: edges.get(u)) {
//            if (visited[v] == 0) {
//                dfs(v);
//                if (!valid) {
//                    return;
//                }
//            } else if (visited[v] == 1) {
//                valid = false;
//                return;
//            }
//        }
//        visited[u] = 2;
//    }


    /**
     * 拓补排序   运用广度 + 队列的方式
     */


    List<List<Integer>> edges1;//这个是顺序的
    int[] indeg1;//// 这个是从来计量每个节点的入读的
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        //初始化
        edges1 = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges1.add(new ArrayList<Integer>());
        }
        indeg1 = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            //而且还要加入入度+1
            ++indeg1[info[0]];
        }
        //创建一个队列
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            //如果入度为0 的时候  就可以进入队列
            if (indeg1[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
//            只要队列不是空的
            ++visited;
            //取出队列中的数值  ，然后进行计算
            int u = queue.poll();
            for (int v: edges.get(u)) {
                //减去他们前面的那个节点
                --indeg1[v];
                //若节点的入度为0的时候就加入队列
                if (indeg1[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}
