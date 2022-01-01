package com.shangzhizheng;

import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 15:12
 * @description 35. 搜索插入位置
 */
public class T35 {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


}
