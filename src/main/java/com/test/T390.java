package com.test;

/**
 * @auther wuqiong
 * @date 2022/1/2
 * @time 10:30
 * @description 390. 消除游戏
 */
public class T390 {

    public static void main(String[] args) {
        int i = new T390().lastRemaining(4);
        System.out.println(i);

    }

    public int lastRemaining1(int n) {
        int a1 = 1, an = n;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) { // 正向
                a1 = a1 + step;//修改第一个元素
                an = (cnt % 2 == 0) ? an : an - step;//修改最后一个元素
            } else { // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;//修改最后一个元素
                an = an - step;//修改第一个元素
            }
            k++;//这个代表的是正反方向的
            cnt = cnt >> 1;  //这个直接/2  why ?  ->  每次循环完毕  所有的数都会减少一半的数量
            step = step << 1;//这个是直接*2  所以剩下的步长会增加一倍
        }
        return a1;
    }



    /**
     * 正常的解题步骤   不过超出了内存的限制
     */
    public int lastRemaining(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }

        int count = 0;
        while (arr.length != 1){
            arr = lastRemaining(arr.length,count,arr);
            count++;
        }

        return arr[0];

    }
    public int[] lastRemaining(int n,int a,int[] arr) {
        int[] arr1 = new int[n/2];

        if (a%2==0){
            for (int i = 1,j=0; i < arr.length; i+=2, j++) {
                arr1[j] = arr[i];
            }
        }else {
            for (int i = arr.length-2,j=arr1.length-1; i >= 0; i-=2, j--) {
                arr1[j] = arr[i];
            }
        }
        return arr1;
    }

}
