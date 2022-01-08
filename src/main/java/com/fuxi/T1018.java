package com.fuxi;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther wuqiong
 * @date 2022/1/7
 * @time 14:11
 * @description 可被 5 整除的二进制前缀
 */
public class T1018 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
//5->   4+1  -> 101  ->101
        ArrayList<Boolean> list = new ArrayList<>();
        int num=nums[0];
        if (num==0){
            list.add(true);
        }else {
            list.add(false);
        }
        for (int i = 1; i < nums.length; i++) {
            num = num<<1;
            num+=nums[i];
            if ((num%=5)==0){
                list.add(true);
            }else {
                list.add(false);
            }
        }
        return list;
    }

    public List<Boolean> prefixesDivBy51(int[] nums) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int prefix = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }


}
