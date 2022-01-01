package com.LQB11;

import com.sun.media.sound.SoftTuning;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 16:09
 * @description   门派的制作
 */
public class A {

    
    //请问要制作所有的 1 到 2020 号门牌，总共需要多少个字符 2？
    public static void main(String[] args) {
        int count =0;
        for (int i = 0; i <=2020; i++) {
           int res = i;
            while (res>0){
                if (res % 10  == 2){
                    count++;
                }
                res = res/10;
            }

        }
        System.out.println(count);
    }


    public void main2(){

            int count = 0;
            for (int i = 1; i <=2020; i++) {
                String s = String.valueOf(i);
                if (s.contains("2")) {
                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j)=='2') {
                            count++;
                        }

                    }
                }
            }
            System.out.println(count); //624

    }

}
