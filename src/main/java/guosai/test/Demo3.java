package guosai.test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @auther wuqiong
 * @date 2022/3/24
 * @time 18:47
 * @description
 */
public class Demo3 {

    //这个是求解最大的公约数
    public static int gcd(int a,int b) {
        return a==0 ? b : gcd(b % a ,a);
    }

    //这个是求解最小的公倍数

    public static int lcb(int a ,int b) {
        int aa = gcd(a,b);
        return a* b /aa;
    }

    static int n = 2021;

    public static void main(String[] args) {

        int[][] floyd  =new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n && j < i+22; j++) {
                floyd[i][j] = floyd[j][i] = lcb(i+1,j+1);
            }
        }

        for (int i = 0; i < floyd.length; i++) {
            for (int j = 0; j < floyd.length; j++) {
                for (int j2 = 0; j2 < floyd.length; j2++) {

                    //这里就是正式的运用了那floyd算法
                    if (floyd[j][j2] != 0 && floyd[i][j] !=0 && (floyd[i][j2]==0 || (floyd[i][j] + floyd[j][j2] < floyd[i][j2]))) {
                        floyd[i][j2] =floyd[i][j]+ floyd[j][j2];
                    }
                }
            }


        }
        System.out.println(floyd[0][n-1]);


    }
}
