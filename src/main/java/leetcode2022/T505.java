package leetcode2022;

import java.awt.image.DirectColorModel;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther wuqiong
 * @date 2022/3/21
 * @time 20:36
 * @description  迷宫II
 */
public class T505 {


    //DFS
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] ints : distance) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze,start,distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];

    }

    private void dfs(int[][] maze, int[] start, int[][] distance) {
        //首先定义四个方向
        int[][] disr = {{-1,0},{1,0},{0,1},{0,-1}};
        for (int[] ints : disr) {

            //why加上一个ints[0][1]  这是先加了一个没有计算进来  相当于 + 1 - 1 得判断而下面得while循环就是起到判断的作用
            int x = start[0] + ints[0];
            int y = start[1] + ints[1];

            int count  = 0;


            //这里就是count+1
            //这个就是向不同得方向移动
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += ints[0];
                y += ints[1];
                count++;
            }

            //然后 如果有更下得蓄力那么就更新所给定得距离
            if (distance[start[0]][start[1]] + count < distance[x - ints[0]][y - ints[1]]) {
                distance[x - ints[0]][y - ints[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - ints[0],y - ints[1]}, distance);
            }

        }
    }


    /**
     * BFS
     * @param maze
     * @param start
     * @param dest
     * @return
     */
    public int shortestDistance1(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
        Queue< int[] > queue = new LinkedList< >();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    /**
     * Dijkstra
     */

    public int shortestDistance3(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        for (int[] row: distance)
            //首先默认的赋值为最大的数值
            Arrays.fill(row, Integer.MAX_VALUE);
//        初始化起始位置
        distance[start[0]][start[1]] = 0;

        dijkstra(maze, distance, visited);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }


    public int[] minDistance(int[][] distance, boolean[][] visited) {
        int[] min={-1,-1};
        int min_val = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                if (!visited[i][j] && distance[i][j] < min_val) {
                    min = new int[] {i, j};
                    min_val = distance[i][j];
                }
            }
        }
        return min;
    }

    public void dijkstra(int[][] maze, int[][] distance, boolean[][] visited) {
        int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};

        while (true) {
            //这个得到那个i或者j的
            int[] s = minDistance(distance, visited);
            if (s[0] < 0)
                break;
            //这里是确认到已经访问过了
            visited[s[0]][s[1]] = true;

            //每个方向都有一条有权的数值
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                }
            }
        }


    }


}
