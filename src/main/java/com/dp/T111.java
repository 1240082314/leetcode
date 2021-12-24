package com.dp;

/**
 * @auther wuqiong
 * @date 2021/12/10
 * @time 15:19
 * @description  二叉树的最小深度
 */
public class T111 {

    /**
     *          2
     *              3
     *                  4
     *                       5
     *                             6
     **/

    public int minDepth(TreeNode root) {
        if (root==null) return 0;

        int left =minDepth(root.left)+1;
        int right = minDepth(root.right)+1;

        return Math.min(left,right);
    }
}
