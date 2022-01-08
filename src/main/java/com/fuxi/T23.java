package com.fuxi;


import java.net.ServerSocket;
import java.util.Queue;
import java.util.Stack;

/**
 * @auther wuqiong
 * @date 2022/1/6
 * @time 13:40
 * @description 回文链表
 *
 * 1.  方法1 将链表的数据复制到数组当中然后使用双指针的方法一一比对
 * 2.  方法2 运用栈的方式
 * 3.  方法3 运用递归
 * 4.  方法4 快慢指针
 */
public class T23 {




    //2.判断是否是回文的链表
    public boolean isPalindrome2(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        while (node!=null){
            stack.push(node);
            node = node.next;
        }
        int size = stack.size();
        while (!stack.isEmpty() && stack.size()==size/2+1){
            if ((stack.pop()).val!=head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }


//    初始化这个前节点
    private ListNode frontPointer;

    private boolean recursivelyCheck3(ListNode currentNode) {
        //一直找到最后一个节点位置  如果等于null就不用寻找了
       if (currentNode!=null){
           if (!recursivelyCheck3(currentNode.next)){
               return false;
           }
           //递归执行完毕就要对数据进行比对
           if (currentNode.val != frontPointer.val){
               return false;
           }
           frontPointer=frontPointer.next;
       }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck3(head);
    }




    //---------------------------------------------------------
    //方法4
    //快慢指针的方式就是找到中间节点，然后反转，一一比对，，最终的结果在进行反转回来
    public boolean isPalindrome4(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }



    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }




}
