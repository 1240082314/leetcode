package com.huadongchuangkou;

import java.util.*;

/**
 * @auther wuqiong
 * @date 2021/12/18
 * @time 10:52
 * @description 至多字符串的问题
 */
public class T159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left =0,right =0;
        int n = s.length();
        if (n<3){
            return n;
        }
        int max_len=2;
        while (right<n){
            //这个map后面存储的是那个元素最后一次出现的位置
            if (map.size()<3){
                map.put(s.charAt(right),right);
            }

            //如果是等于3的时候那么  此时说明他的范围已经超出去了
            if (map.size()==3){
                Integer min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min+1 ;
            }
            // a b a c d-> left = 3 - 3 =0
            max_len = Math.max(max_len, right - left+1);
            right++;
        }


        return max_len;


    }
}
