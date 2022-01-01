package com.LQB11;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 16:49
 * @description  排序
 */
public class E {
    //15:105  需要减少5次的排序-> 最短传数列 ->  点序列最小
    //onmlkjihgfedcba->105次数
    //jonmlkihgfedcba->
    public static void main(String[] args) {
        //冒泡排序最多的次数是
        for(int i=1; i<20; ++i) {
            System.out.println(i+":"+((i-1)*i/2));		//由此可以发现15个字符的逆序通过冒泡交换成顺序所需要的交换次数最接近100，因此仅需要将onmlkjihgfedcba的第六位移动至第一位即可：jonmlkihgfedcba
        }
    }

}
