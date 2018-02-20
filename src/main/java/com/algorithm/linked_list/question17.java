package com.algorithm.linked_list;

/**
 * 给定两个有序单链表的表头head1和head2,请合并两个单链表合并后的单链表依旧是有序的
 */
public class question17 {
    public static SignNode merge(SignNode head1, SignNode head2){
        if (head1 == null || head2 == null){
            return head1 != null ? head1 : head2;
        }
        SignNode head = head1.num < head2.num ? head1 : head2;
        SignNode cur1 = head == head1 ? head1 : head2;
        SignNode cur2 = head == head2 ? head2 : head1;
        SignNode pre = null;
        SignNode next = null;
        while (cur1 != null && cur2 != null){
            if (cur1.num <= cur2.num){
                pre = cur1;
                cur1 = cur1.next;
            }else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
