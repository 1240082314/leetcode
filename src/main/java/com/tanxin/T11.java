package com.tanxin;


/**
 * @auther wuqiong
 * @date 2021/12/10
 * @time 16:57
 * @description  盛最多水的容器
 */
public class T11 {

    //1.暴力解决问题  但是超出了所给定的时间
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int withd = j-i;
                int heigh = Math.min(height[i], height[j]);
                if (withd* heigh>max){
                    max= withd*heigh;
                }
            }
        }
        return max;
    }

    //2.双指针的解
    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
//            初始化
            int area = Math.min(height[l], height[r]) * (r - l);

            ans = Math.max(ans, area);

            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }


}
