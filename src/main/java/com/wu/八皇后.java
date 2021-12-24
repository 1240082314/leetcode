package com.wu;

/**
 * @auther wuqiong
 * @date 2021/12/6
 * @time 10:38
 * @description
 *
 * 首先利用一个数组存储  排序到第几个皇后的位置
 * int[] queen = new int[8];  queen[1]=1 代表第二个皇后存储在第二个位置
 */
public class 八皇后 {

    static int resultCount = 0;


    /**
     * 判断某个位置和之前的皇后是否矛盾
     * @param arr
     * @param s
     * @return
     */
    private static boolean place(int[] arr, int s) {
        for(int i = 0; i < s; i++) {
            //(arr[i] == arr[s])是否同列
            // (Math.abs(i-s) == Math.abs(arr[i]-arr[s]) 是否同一条斜线
            if((arr[i] == arr[s]) || (Math.abs(i-s) == Math.abs(arr[i]-arr[s]))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 遍历每一行是否能放入皇后
     * @param arr
     * @param i
     * @param n
     */
    public static void tria(int[] arr, int i, int n) {
//        只要达到最后一行说明满足一种情况
        if(i >= n) {
            ++resultCount;
        } else {
            //循环遍历第一行的皇后存放位置可能性
            for(int j = 0; j < n; j++) {
//                i代表的是第几行的皇后，j代表是皇后在哪里
                arr[i] = j;
                //判断是否冲突 若冲突继续下一行，若冲突就下一列
                if(place(arr, i)) {
                    //如果不冲突继续下一行
                    tria(arr, i+1, n);//如果不冲突的看i继续将i+1  否则就回溯
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] queen = new int[8];
        tria(queen, 0, 8);

        System.out.println(resultCount);
    }

}
