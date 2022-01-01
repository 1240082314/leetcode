package com.LQB11;

import java.util.Scanner;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 17:01
 * @description
 */
public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] ch = sc.nextLine().toCharArray();
        int[] r = new int[26];
        for(int i=0; i<ch.length; ++i) {
            ++ r[ch[i]-'a'];
        }

        char res = 'a';
        int max = Integer.MIN_VALUE;
        for(int i=0; i<r.length; ++i) {
            if(r[i]>max) {
                res = (char)('a'+i);
                max = r[i];
            }
        }

        System.out.println(res);
        System.out.println(max);
    }

}
