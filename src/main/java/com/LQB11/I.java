package com.LQB11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 17:14
 * @description 子串分值和
 */
public class I {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.nextLine().toCharArray();
        boolean[] vis = new boolean[26];
        int size = 0;
        long res = 0;
        for (int i = 0; i < ch.length; ++i) {
            Arrays.fill(vis, false);
            size = 0;
            for (int j = i; j < ch.length; ++j) {
                if (!vis[ch[j] - 'a']) {
                    ++size;
                    vis[ch[j] - 'a'] = true;
                }
                res += size;
            }
        }
        System.out.println(res);
    }

}
