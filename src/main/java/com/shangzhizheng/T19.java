package com.shangzhizheng;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @auther wuqiong
 * @date 2022/1/4
 * @time 11:17
 * @description. 删除链表的倒数第 N 个结点
 */
public class T19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int m = 1;
        ListNode test = head;
        while (test.next!=null){
            test = test.next;
            m++;
        }
        int c = m - n;
        ListNode test1 = head;
        for (int i = 0; i < c-1; i++) {
             test1= test1.next;
        }
        //这个时候就需要删除节点
        test1.next = test1.next.next;

        return dummy.next;
    }


    /**
     * 官方的解答1
     * @param head
     * @param n
     * @return
     */
        public ListNode removeNthFromEnd1(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            int length = getLength(head);
            ListNode cur = dummy;
            for (int i = 1; i < length - n + 1; ++i) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            ListNode ans = dummy.next;
            return ans;
        }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     * 解答2  栈
     */

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    /**
     * 双指针
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;//1
        ListNode second = dummy;//2
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }




}
