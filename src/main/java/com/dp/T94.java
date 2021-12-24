package com.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther wuqiong
 * @date 2021/12/9
 * @time 21:34
 * @description  中序遍历
 */
public class T94 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        //  中  左  右
        List<Integer> list = new ArrayList<>();

      this.inorderTraversal(root,list);

        return list;
    }

    public void inorderTraversal(TreeNode root,List<Integer> list ) {
        //  中  左  右
        if (root==null){
            return;
        }
        this.inorderTraversal(root.left,list);
        list.add(root.val);
        this.inorderTraversal(root.right,list);

    }

}
