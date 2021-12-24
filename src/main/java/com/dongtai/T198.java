package com.dongtai;

import com.sun.corba.se.spi.ior.MakeImmutable;
import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * @auther wuqiong
 * @date 2021/12/9
 * @time 17:24
 * @description  打家劫舍
 *
 */
public class T198 {

    public static void main(String[] args) {
        System.out.println(new T198().rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
//

        int[] max = new int[nums.length];
        if (nums.length==1){
            return nums[0];
        }

        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        max[0]=nums[0];
        max[1]= Math.max(nums[0],nums[1]);

        for (int r = 2; r < max.length; r++) {
            max[r] = Math.max(max[r-2]+nums[r],max[r-1]);
        }

        return max[nums.length-1];



    }
}
