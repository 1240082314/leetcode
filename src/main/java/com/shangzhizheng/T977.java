package com.shangzhizheng;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.Arrays;

/**
 * @auther wuqiong
 * @date 2021/12/27
 * @time 13:46
 * @description   有序数组的平方
 */
public class T977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T977().sortedSquares(new int[]{-4, -1, 0, 3, 10})));

    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right =nums.length-1;
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])){
                arr[nums.length-i-1]= (int) Math.pow(nums[left],2.0);
                left++;
            }else {
                arr[nums.length-i-1]= (int) Math.pow(nums[right],2.0);
                right--;
            }

        }
        return arr;
    }
}
