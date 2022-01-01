package com.shangzhizheng;

/**
 * @auther wuqiong
 * @date 2021/12/27
 * @time 13:55
 * @description  轮转数组
 */
public class T189 {

    /**
     * 利用新的数组
     */
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[(i+k) % nums.length]=nums[i];
        }

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
    }

    /**
     *  环状的替换
     *   1. 步长为 k   遍历了元素 b  = 长度为 n  设置为a圈
     *
     *  -> bk = an  其中要求是 a是最小的
     *  即  bk = an     an是k的倍数   an是n的倍数
     *  an 是  k 和 n 的lcm公倍数  而最终要求得数是单次遍历所需要得元素 b/a
     *
     *  -> b = lcm(n,k) / k
     *  最终一圈遍历得个数就是  b / a  lcm(n,k) / a
     */

    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }


    //求解两个数得最大公因数  大    小
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }



}
