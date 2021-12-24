package com.dp;

import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * @auther wuqiong
 * @date 2021/12/9
 * @time 22:05
 * @description  求解答深度
 */
public class T104 {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return Math.max(left,right);

    }
}
