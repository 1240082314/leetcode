package com.tanxin;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.UnknownFormatConversionException;

/**
 * @auther wuqiong
 * @date 2021/12/13
 * @time 21:56
 * @description 分发饼干
 */
public class T445 {

    public static void main(String[] args) {
        System.out.println(new T445().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(new T445().findContentChildren(new int[]{1, 2}, new int[]{1, 2,3}));
        System.out.println(new T445().findContentChildren(new int[]{1, 2,3}, new int[]{3}));
        System.out.println(new T445().findContentChildren(new int[]{7, 8,9,10}, new int[]{5,6,7,8}));
    }
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int r = 0; r < g.length; r++) {
            boolean flag = true;
            for (; j < s.length; j++) {
                if (s[j]>=g[r]){
                    count ++;
                    s[j]=-1;
                    flag=false;
                    break;
                }
            }
            if (flag){
                break;
            }

        }
        return count;

     }
//    public int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
////        System.out.println(Arrays.toString(g));
//        int index=0;
//        int sum =0;
//        for (int i = 0; i < s.length; i++) {
//           sum=+s[i];
//        }
//        for (int i = 0; i < g.length; i++) {
//            sum-=g[i];
//            if (sum<0 ){
//                index = i;
//                break;
//            }
//            if ( i==g.length-1)
//            {
//                index = i+1;
//            }
//        }
//        return index;
//    }

    /**
     * 官方解答  贪心2
     *
     */

    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }


}
