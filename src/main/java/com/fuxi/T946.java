package com.fuxi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @auther wuqiong
 * @date 2022/1/7
 * @time 17:00
 * @description  验证栈序列
 */
public class T946 {

    public static void main(String[] args) {
//        System.out.println(new T946().validateStackSequences1(new int[]{1, 2, 3, 4, 5,}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(new T946().validateStackSequences1(new int[]{1, 0}, new int[]{1,0}));
    }
//    //验证栈的序列
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
//        贪心算法
        Deque<Integer> deque = new LinkedList<>();
        int n = popped.length;
        deque.push(pushed[0]);
        //首先deque不是null
        int i =0;
        int j =1;
        while (!deque.isEmpty()   &&  j <= pushed.length ){
            while (deque.peek() != popped[i]){
                if (j==pushed.length){
                    return false;
                }
                deque.push(pushed[j++]);
            }
            //如果碰到了 deque.peek == 取出来的数值的话，那么就直接取出数值
            deque.poll();
            i++;
        }

        return i == n;
    }



        public boolean validateStackSequences(int[] pushed, int[] popped) {


//            贪心算法
            Deque<Integer> deque = new LinkedList<>();

            int j =0;
            for (int push : pushed) {
                deque.push(push);
                //看看有没有相等的
                while (!deque.isEmpty() &&  j< popped.length &&deque.peek()==popped[j] ){
                    deque.pop();
                    j++;
                }
            }
            return j == pushed.length;
        }
}
