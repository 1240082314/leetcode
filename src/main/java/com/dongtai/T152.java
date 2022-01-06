package com.dongtai;

/**
 * @auther wuqiong
 * @date 2022/1/2
 * @time 11:28
 * @description  乘积最大的连续数组
 */
public class T152 {
    public static void main(String[] args) {
//        System.out.println(new T152().maxProduct(new int[]{2, 3, -2, 4}));
//        System.out.println(new T152().maxProduct(new int[]{-2,0,-1}));
        System.out.println(new T152().maxProduct(new int[]{2,3,-2,4}));
    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for(int i=0; i<nums.length; i++){
//            如果碰到了了就交换
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }




    public int maxProduct1(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }


}
