package com.dongtai;

/**
 * @auther wuqiong
 * @date 2021/12/8
 * @time 15:12
 * @description  最大的来连续子数组
 */
public class T53 {

    public static void main(String[] args) {
        System.out.println(new T53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
//   0 1  1 5
// [-2,1,-3,4,-1,2,1,-5,4]  pre 代表的是以i结尾的最大的前缀和，，如果
    //  pre = -2  max = -2
    //  pre = 1  max = 1
    //  pre = 1  max = 1
    //  pre = 5  max = 5

    /**
     * 动态规划的问题
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0 ;
        int maxAns = nums[0];

        for (int x : nums) {
            //找出最大的前缀
            pre = Math.max(pre + x, x);
            //然后看前缀大还是原来的那个数大
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }



//    public int lSum, rSum, mSum, iSum;
//
//    public T53(int lSum, int rSum, int mSum, int iSum) {
//        this.lSum = lSum;
//        this.rSum = rSum;
//        this.mSum = mSum;
//        this.iSum = iSum;
//    }
//
//
//    public int maxSubArray1(int[] nums) {
//        return getInfo(nums, 0, nums.length - 1).mSum;
//    }
//
//    public T53 getInfo(int[] a, int l, int r) {
//        if (l == r) {
//            return new T53(a[l], a[l], a[l], a[l]);
//        }
//        int m = (l + r) >> 1;
//        T53 lSub = getInfo(a, l, m);
//        T53 rSub = getInfo(a, m + 1, r);
//        return pushUp(lSub, rSub);
//    }
//
//    public T53 pushUp(T53 l, T53 r) {
//        int iSum = l.iSum + r.iSum;
//        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
//        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
//        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
//        return new T53(lSum, rSum, mSum, iSum);
//    }


}
