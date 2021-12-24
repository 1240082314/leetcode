package com.LQB12;

/**
 * @auther wuqiong
 * @date 2021/12/9
 * @time 15:35
 * @description  卡片
 */
public class B {
    //0-9   2021张
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
             arr[i]=2021;
        }
        int n =1;
        OUT:while (true){
//            这个是取最后面的个位数字
            int x = n % 10;//1
            int n1 = n;//1
            while (x >= 0){
                arr[x]--;
                if (arr[x]<0){
                    System.out.println(n-1);
                    break OUT;
                }
                n1 = n1 / 10;//这个是去除掉最后一位数字1/10 =0

                //这里的判断有10 和 0的矛盾  如果是n1为0的话就直接退出，，否则10的话还可以继续
                if (n1 == 0) {
                    break ;
                }
                x = n1 % 10;//0%10 =0
            }
            n++;
        }
    }
}
