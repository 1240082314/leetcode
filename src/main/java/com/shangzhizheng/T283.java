package com.shangzhizheng;

/**
 * @auther wuqiong
 * @date 2022/1/4
 * @time 10:50
 * @description 移动0
 */
public class T283 {

    public void moveZeroes(int[] nums) {
        int j =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 官方
     */

    public void moveZeroes1(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
