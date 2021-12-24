package com.wu;

import java.util.HashSet;
import java.util.concurrent.CancellationException;

/**
 * @auther wuqiong
 * @date 2021/12/4
 * @time 10:23
 * @description
 */
public class T383 {

    /**
     * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
     *
     * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
     *
     * 如果可以构成，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * @param args
     */

    public static void main(String[] args) {

        System.out.println(new T383().canConstruct("aa", "ab"));
    }


    //自己写的答案
    public boolean canConstruct(String ransomNote, String magazine) {
        //赎金信

        int[] arr = new int[26];

        for (int r = 0; r < arr.length; r++) {
            System.out.println(arr[r]);

        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index= (ransomNote.charAt(i)-'a');
           arr[index]--;
        }
        for (int i = 0; i < magazine.length(); i++) {
            int index= (magazine.charAt(i)-'a');
            arr[index]++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i]<0){
                return false;
            }
        }
        return true;

    }


    //官方解答
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


}
