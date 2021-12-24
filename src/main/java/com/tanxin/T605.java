package com.tanxin;


import java.util.UnknownFormatConversionException;
import java.util.jar.Manifest;

/**
 * @auther wuqiong
 * @date 2021/12/13
 * @time 21:30
 * @description  种花问题
 */
public class T605 {
    public static void main(String[] args) {
        System.out.println(new T605().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(new T605().canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
//        [1,0,0,0,1,0,0]
        System.out.println(new T605().canPlaceFlowers(new int[]{1,0,0,0,0,0,1 }, 2));
    }


    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i]==1){
                i++;
                continue;
            }
            if (flowerbed[i]==0){
                if ( flowerbed.length==i+1 ||i+1 < flowerbed.length && flowerbed[i+1] ==0 ){
                    n--;
                    i++;
                }
            }
        }
        if (n<=0){
            return true;
        }else {
            return false;
        }

    }

    /**
     * 贪心  官方解答
     */
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;

        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                //说明这个是第一朵话  0左边没有话 -> 0  1->0  下表就是指的是 有几个空的位置 但是 n-1+1 /2
                if (prev < 0) {
                    count += i / 2;
                } else {
                    //否则就是要 有 ((i -prev -1)-2+1 )/2
                    count += (i - prev - 2) / 2;
                }
                //移动上一次的数值
                prev = i;
            }
        }

//        特殊情况  这种情况就是没有1  所以就是直接复制
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }

}
