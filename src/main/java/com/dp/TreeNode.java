package com.dp;

/**
 * @auther wuqiong
 * @date 2021/12/9
 * @time 22:05
 * @description 节点
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;

    }
}
