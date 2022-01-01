package com.LQB11;

/**
 * @auther wuqiong
 * @date 2021/12/26
 * @time 16:19
 * @description 蛇形填数
 */
public class C {

    //第一行1 第二行2 第三行3 第四行4 奇数下->上   偶数 上->下

    //20行20列->  39

    public static void main1(String[] args) {
        int sum =0;
        for (int i = 0; i < 39; i++) {
           sum +=i;
        }
        System.out.println(sum);

        //781开始，，都是从第一列开始 -> 39 1 -> 20 20
                            //        741    781
    }

    public static void main(String[] args) {
        int res = 1, t = 4;

        for(int i=2; i<=20; ++i) {
            res += t;
            t += 4;
        }

        System.out.println(res);		//761
    }


}
