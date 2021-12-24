package com.dongtai;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;

/**
 * @auther wuqiong
 * @date 2021/12/8
 * @time 14:57
 * @description
 *  杨辉三角
 */
public class T118 {

    public static void main(String[] args) {
        System.out.println(new T118().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list1 = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list2 = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j==0 || j==i-1){
                    list2.add(1);
                }else {
                    list2.add(list1.get(i-2).get(j-1)+list1.get(i-2).get(j));
                }
            }
            list1.add(list2);

        }

        return list1;
    }


    //官方解答
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }


}
