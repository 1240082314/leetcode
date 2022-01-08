package com.fuxi;

import javax.swing.text.html.HTMLWriter;
import java.util.*;

/**
 * @auther wuqiong
 * @date 2022/1/7
 * @time 15:08
 * @description 验证二叉树的前序序列化
 */
public class T331 {

    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        //栈
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }


}
