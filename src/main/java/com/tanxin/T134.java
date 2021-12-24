package com.tanxin;

import java.util.Arrays;
import java.util.UnknownFormatConversionException;

/**
 * @auther wuqiong
 * @date 2021/12/16
 * @time 10:41
 * @description  加油站
 */
public class T134 {
    // gas  = [1,2,3,4,5]  这个是加油站 可以加的油
    //cost = [3,4,5,1,2]  这个是消耗的油
    public static void main(String[] args) {
        System.out.println(new T134().canCompleteCircuit2(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
//        new T134().canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3});
    }

    /**’
     * 空间超出限制了
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int[][] nums = new int[gas.length][gas.length];
//        int[][] costs= new int[gas.length][gas.length];
        for (int i = 0; i < gas.length; i++) {
            //从i开始
            int sum = 0;

            //j结束
            for (int j = 0; j < nums.length; j++) {
                sum += gas[(i + j) % nums.length];//sum =4    cost =3 -> 1
                nums[i][(i + j) % nums.length] = sum - cost[(i + j) % nums.length];
                sum -= cost[(i + j) % nums.length];


            }

        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
            ;
        }

        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i][j] < 0) {
                    flag = false;
                }
            }

            if (flag) {
                return i;

            }
//            System.out.println(1111111);

        }

        return -1;
    }


    /**
     * 这个是时间超出限制了
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {

        int[] nums = new int[gas.length];

        for (int i = 0; i < gas.length; i++) {
            //从i开始
            int sum = 0;
            boolean flag = true;
            //j结束
            for (int j = 0; j < nums.length; j++) {
                sum += gas[(i + j) % nums.length];//sum =4    cost =3 -> 1
                nums[(i + j) % nums.length] = sum - cost[(i + j) % nums.length];
                sum -= cost[(i + j) % nums.length];

                if (nums[(i + j) % nums.length] < 0) {
                    flag = false;
                }
            }
            if (flag) {
                return i;

            }
//            System.out.println(11111);
            System.out.println(Arrays.toString(nums));

        }
        return -1;

    }
}
