package com.shangzhizheng;

/**
 * @auther wuqiong
 * @date 2022/1/4
 * @time 11:10
 * @description  链表的中间结点
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class T876 {


    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode head1 = head;
        ListNode next1  = head;

        //防止出现空指针异常
        while ( next1!=null && next1.next!=null){
            head1 = head1.next;
            next1 = next1.next.next;
        }
        return head1;

    }
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
