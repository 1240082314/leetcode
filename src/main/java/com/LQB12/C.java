package com.LQB12;

/**
 * @auther wuqiong
 * @date 2021/12/9
 * @time 18:31
 * @description
 */
public class C {


    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

    }

//    public static void main(String[] args) {
//
//        HashSet hashSet = new HashSet();
//        int[][] arr = new int[20][21];
//        for (double r = 0; r < arr.length; r++) {
//            for (double i = 0; i < arr[0].length; i++) {
//                double x1 = r;
//                double y1 = i;
//                for (double j = 0; j < arr.length; j++) {
//                    for (double k = 0; k < arr[0].length;k++) {
//                        double x2 = j;
//                        double y2 = k;
//                     double a = -x1*x1*y2;
//                     double b = (y1*y1*x2);
//
//                     hashSet.add(new Test(a,b));
//
//                    }
//                }
//            }
//        }
//        System.out.println( hashSet.size()+20);
//    }


}
