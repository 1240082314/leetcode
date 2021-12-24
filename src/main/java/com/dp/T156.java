package com.dp;

/**
 * @auther wuqiong
 * @date 2021/12/18
 * @time 10:26
 * @description  上下翻转树
 */
public class T156 {

    TreeNode head;

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        dfs(root,null);
        return head;
    }

    public void dfs(TreeNode root, TreeNode pre){
        //首先来个前序遍历
        if (root==null) return;

        dfs(root.left,root);

        if (head==null){
            //
            head=root;
        }
        if (pre!=null){
            //
            pre.left=null;
            root.left = pre.right;

            pre.right = null;

            root.right = pre;


        }

        //到这里时候就基本

    }



//    TreeNode head = null;
//    public TreeNode upsideDownBinaryTree(TreeNode root) {
//        //对于root来说，父节点为null
//        dfs(root , null);
//        return head;
//    }
//
//    //节点  父节点
//    public void dfs(TreeNode root , TreeNode pre){
//        if(root == null) return;
//        //前序遍历，先往左走
//        dfs(root.left , root);
//
//        if(head == null){
//            //head置为最左边的节点
//            head = root;
//        }
//        if(pre != null){
//            //父节点的left置为null，不会对遍历过程造成影响，因为左边已经全部遍历完成了
//            pre.left = null;
//            //当前节点左节点置为父节点的右节点
//            root.left = pre.right;
//            //父节点的right置为null，不会对遍历过程造成影响，因为右节点已经在上层进行了记录
//            pre.right = null;
//            //当前节点右节点置为父节点
//            root.right = pre;
//        }
//    }


}
