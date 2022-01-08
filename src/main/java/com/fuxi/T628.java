package com.fuxi;

import sun.util.resources.cldr.mua.CurrencyNames_mua;

import java.util.Arrays;

/**
 * @auther wuqiong
 * @date 2022/1/7
 * @time 14:38
 * @description 三个数的最大乘积
 */
public class T628 {

    //三个数的最大乘积  ->  两个最小的一个最大的数   ->   或者三个最大的数
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]* nums[1]*nums[nums.length-1],nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
}
