package com.shangzhizheng;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 14:39
 * @description  二分查找
 */
public class T804 {

    public static void main(String[] args) {
//        System.out.println(new T804().search(new int[]{-1, 0, 3, 5, 9, 12}, 13));
//        System.out.println(new T804().search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(new T804().search(new int[]{2,5}, 0));
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
         return search(nums,target,low,high);
    }

    public int search(int[] nums, int target,int left, int right) {
//        +1是代表得是取上界-【-1,0,3,5,9,12】 1 1 -> 1
        int mid = left + (right-left)/2; // 0 4  -> 2   0  1 -> 0

        //注意越界得问题
        if (left >= right && nums[left] != target) return -1;

//        下面就是递归得调用
        if (nums[mid] > target){
            return search(nums,target,left,mid-1);
        }else if (nums[mid] < target){
            return search(nums,target,mid+1,right);
        }else {
            return mid;
        }


    }

    /**
     * 官方解答
     */

    public int search1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

//        利用两个指针得方法
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
