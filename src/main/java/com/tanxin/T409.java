package com.tanxin;

/**
 * @auther wuqiong
 * @date 2021/12/13
 * @time 22:40
 * @description 最长回文串
 */
public class T409 {


    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();

        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;//只能加一个偶数
            //前一个是奇数，后一个是偶数情况下  就可以再加1  否则  就是
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


}
