package com.fuxi;

import java.lang.annotation.ElementType;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @auther wuqiong
 * @date 2022/1/8
 * @time 13:15
 * @description 0. 有效的括号
 *
 *     }
 */
public class T20 {


    //理一下思路  如果栈当中出现反括号得时候  有两中可能返回false
    public boolean isValid(String s) {

        Deque deque = new LinkedList();

        char[] chars = s.toCharArray();
        HashMap<Character,Character> hashMap = new HashMap();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');

        for (int i = 0; i < chars.length; i++) {
            if (chars[i]== '(' || chars[i]== '['  || chars[i]== '{'  ){
                deque.push(chars[i]);
            }else {
                if (!deque.isEmpty()){
                    if (hashMap.get(chars[i]) == deque.peek()){
                        deque.pop();
                    }else {
                        return false;
                    }


                }else {
                    return false;
                }
            }
            //循环完毕，，如果栈单中是null得就直接返回true

        }

        return deque.isEmpty();

    }
}

