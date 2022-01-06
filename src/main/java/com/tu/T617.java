package com.tu;

import com.dp.TreeNode;
import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;

/**
 * @auther wuqiong
 * @date 2022/1/6
 * @time 10:16
 * @description 合并二叉树
 */
public class T617 {


    /**
     * 合并二叉树  dfs
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
       if (root1==null){
           return root2;
       }
       if (root2==null){
           return root1;
       }

       TreeNode treeNode = new TreeNode(root1.val + root2.val);

       treeNode.left = mergeTrees(root1.left,root2.left);
       treeNode.right = mergeTrees(root1.right,root2.right);

       return treeNode;

    }

//    public void dfs(TreeNode root1, TreeNode root2,TreeNode treeNode) {
//        if (root1==null && root2 ==null){
//            //如果两个都为null 的情况就要删除那个节点
//            treeNode = null;
//            return;
//        }
//
//
//        int a1 = root1 == null ? 0:  root1.val;
//        int a2 = root2 == null ? 0:  root2.val;
//
//        treeNode.val = a1+a2;
//
//        if (root1==null){
//            treeNode.left = new TreeNode(0);
//            dfs(new TreeNode(0),root2.left,treeNode.left);
//            treeNode.right = new TreeNode(0);
//            dfs(new TreeNode(0),root2.right,treeNode.right);
//        }
//
//        if (root2==null){
//            treeNode.left = new TreeNode(0);
//            dfs(root1.left,new TreeNode(0),treeNode.left);
//            treeNode.right = new TreeNode(0);
//            dfs(root1.right,new TreeNode(0),treeNode.right);
//        }
//
//        treeNode.left = new TreeNode(0);
//        dfs(root1.left,root2.left,treeNode.left);
//        treeNode.right = new TreeNode(0);
//        dfs(root1.right,root2.right,treeNode.right);
//
//    }
}
