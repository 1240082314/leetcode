package com.tanxin;

import com.sun.corba.se.spi.ior.IORFactories;

/**
 * @auther wuqiong
 * @date 2021/12/10
 * @time 17:12
 * @description  跳跃游戏
 */
public class T55 {

    public static void main(String[] args) {
        System.out.println(new T55().canJump(new int[]{3,2,1,0,4}));
    }

    int max =0;

    public boolean canJump(int[] nums) {
        //1.首先取第一个元素
        max=nums[0];
        if (max >= nums.length-1) return true;
        //2. 这时候可以跳跃的区间就是  0 0+a1
        return this.canJump(0,max,nums);
    }
//0 -> 2   2
    public boolean canJump(int begin,int end,int[] nums) {
        for (int i = begin; i <= end; i++) {
            if (i+nums[i]>max){
                max= i+nums[i];
            }
        }
        if (max >= nums.length-1) return true;
        if (max < end+1){
            return false;
        }

        return this.canJump(end+1,max,nums);
    }


    /**
     * 官方给出的贪心答案
     * @param nums
     * @return
     */

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


}
