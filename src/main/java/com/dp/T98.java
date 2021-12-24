package com.dp;

import org.w3c.dom.ls.LSException;
import sun.plugin2.os.windows.FLASHWINFO;

import javax.swing.*;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther wuqiong
 * @date 2021/12/10
 * @time 14:21
 * @description  验证二叉搜索树
 */
public class T98 {


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }



    //写一个中序遍历
    public boolean isValidBST2(TreeNode root) {
//        只要队列等于空或者root节点不等于空就继续循环
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {

//            每一次都是先将root送进去，，
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//然后取出来的是最后放进去的那个


            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;//这个永远保持的是最小的数值
            root = root.right;
        }
        return true;
    }


    public boolean isValidBST2_1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();

        int min =  -Integer.MAX_VALUE;

        while (!deque.isEmpty()|| root != null){

            while (root!=null){
                deque.push(root);
                root= root.left;
            }
            root=deque.pop();
            if (root.val <= min){
                return false;
            }
            //更换最小的数值
            min= root.val;
            root = root.right;
        }
        return true;
    }

    /**
     *  中序遍历的解答过程
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        //写一个中序遍历
        List<Integer> list = new ArrayList<>();
        // 左  中  右
        isValidBST4(root,list);
        for (int i = 0; i < list.size()-1; i++) {
           if ( list.get(i)>list.get(i+1)){
               return false;
           }
        }
        return true;
    }

    public void isValidBST4(TreeNode root,List<Integer>  list) {
        //写一个中序遍历

        // 左  中  右
        if (root==null ){
            return ;
        }
        isValidBST4(root.left, list);
        list.add(root.val);
        isValidBST4(root.right, list);
    }


}
