package com.tu;

import com.sun.corba.se.spi.ior.IORFactories;
import com.sun.openpisces.TransformingPathConsumer2D;
import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther wuqiong
 * @date 2022/1/6
 * @time 10:45
 * @description  填充每个节点的下一个右侧节点指针
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class T116 {

    public Node connect(Node root) {
        //如何对树进行广度遍历
        Node next = root;
        Queue<Node> queue =new LinkedList();
        queue.add(next);
        while (queue!=null ){



            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node node = queue.poll();
                //没有到最后一个元素
                if (i<size-1){
                    node.next = queue.peek();
                }else {
                    node.next= null;
                }

                if (node.left!= null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
