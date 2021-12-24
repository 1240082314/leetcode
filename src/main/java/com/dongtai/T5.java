package com.dongtai;

/**
 * @auther wuqiong
 * @date 2021/12/9
 * @time 14:41
 * @description 最长的回文子串
 */
public class T5 {

    public String longestPalindrome(String s) {
        int len = s.length();

        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 首先长度为 1 的必须是回文数
     * 然后长度为 2 首先判断前一个长度的是是否是回文数，在判断前后
     * 最后长度为 3 的判断前后是否回文数 判断1是否是回文数
     */
    public String longestPalindrome1(String s) {


        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        //0.长度为1的必须是回文数
        boolean[][] dp = new boolean[len][len];//从i 到 j 是否回文
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        //1.首先是确定回文数的长度
        for (int L = 1; L <= len; L++) {
            //2.然后确定左边界
            for (int i = 0; i < dp.length; i++) {

                //3.根据长度来确定有边界
                int j = i + L - 1;

                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                //4.判断两个边界是否相等
                if (s.charAt(i) == s.charAt(j)) {
                    //5.如果长度为2的时候一定是回文数
                    if (L < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                //最后根据那个回文数，来获取到字符串
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }


        return s.substring(begin, begin + maxLen);


    }


}
