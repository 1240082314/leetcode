package com.dp;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * @auther wuqiong
 * @date 2021/12/10
 * @time 14:26
 * @description  对称二叉树
 */
public class T101 {


    public boolean isSymmetric(TreeNode root) {

       if (root==null){
           return false;
       }
      return check(root.left,root.right);
    }


    public boolean check(TreeNode left,TreeNode right) {
        //1.左右节点都是空的
        if (left==null && right==null){
            return true;
        }
        //2.做节点等于空，右节点非空
        if (left==null || right==null){
            return false;
        }

        return left.val==right.val && check(left.left,right.right) && check(right.left,left.right);

    }

}
