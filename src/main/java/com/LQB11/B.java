package com.LQB11;

import java.util.Scanner;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 16:15
 * @description   寻找 2020
 */
public class B {

    static char[][] r = new char[300][300];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<300; ++i) {
            r[i] = sc.nextLine().toCharArray();
        }

        int res = 0;


        //这个是横向的
        for(int i=0; i<300; ++i) {
            for(int j=0; j+3<300; ++j) {
                if(r[i][j]=='2' && r[i][j+1]=='0' && r[i][j+2]=='2' && r[i][j+3]=='0')
                    ++ res;
            }
        }
        //这个是竖向的
        for(int i=0; i+3<300; ++i) {
            for(int j=0; j<300; ++j) {
                if(r[i][j]=='2' && r[i+1][j]=='0' && r[i+2][j]=='2' && r[i+3][j]=='0')
                    ++ res;
            }
        }
        //这个是斜着的可能
        for(int i=0; i+3<300; ++i) {
            for(int j=0; j+3<300; ++j) {
                if(r[i][j]=='2' && r[i+1][j+1]=='0' && r[i+2][j+2]=='2' && r[i+3][j+3]=='0')
                    ++ res;
            }
        }

        System.out.println(res);		//16520

    }

}
