package com.fuxi;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther wuqiong
 * @date 2022/1/6
 * @time 14:09
 * @description  汇总区间
 *
 * 双指针的方法
 */
public class T228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res= new ArrayList<>();

        int left = 0,right = 0;
        while (right < nums.length ){
            left = right;
            right++;
            while (right < nums.length && nums[right-1]+1 == nums[right] ){
                right++;
            }
            //这个时候就可以得出right的数值
            StringBuffer stringBuffer = new StringBuffer();

            if (right-left==1){
                stringBuffer.append(nums[left]);
            }else {
                stringBuffer.append(nums[left]);
                stringBuffer.append("->");
                stringBuffer.append(nums[right-1]);

            }
            res.add(stringBuffer.toString());


        }
        return res;

    }
}
