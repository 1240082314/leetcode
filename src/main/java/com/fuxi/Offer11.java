package com.fuxi;

import java.io.BufferedReader;
import java.util.HashMap;

/**
 * @auther wuqiong
 * @date 2022/1/8
 * @time 13:30
 * @description 剑指 Offer 11. 旋转数组的最小数字
 */
public class Offer11 {

    public static void main(String[] args) {
        System.out.println(new Offer11().minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Offer11().minArray(new int[]{2,2,2,0,1}));
        System.out.println(new Offer11().minArray(new int[]{1,3,5}));
        System.out.println(new Offer11().minArray(new int[]{3,1}));
    }


    //因为这个数组是由排序好得数组而组成得  所以 她可以用二分查找来计算最终得结果
    public int minArray(int[] numbers) {
        int low = 0;
        int right = numbers.length-1;
        int mid = 0;


        while (low < right){
            //所以当两个数相零得时候修改一一下
             mid = low + (right-low)/2;

            if (numbers[low] < numbers[right]) return numbers[low];
            //此时说明  最小得那个数字在右边

            //1. 两个数相邻得情况  走这个相等
            //2. 两个数相等得情况  走这个相等
            if (numbers[mid] > numbers[low]){
                low = mid+1;
                //降序得可能
            }else if (numbers[mid] < numbers[low]){
                right = mid;
            }else {
                low++;
            }
            //什么情况下  才是 -> 那个mid = low

        }

        return numbers[low];



    }

    public int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;

            //估计自己就是最大得
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }



}
