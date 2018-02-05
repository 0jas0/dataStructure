package com.algorithm.linked_list;

/**
 * 反转单链表和双链表
 */
public class question4 {
    public static SignNode revertSignNode(SignNode head){
        SignNode pre = null;
        SignNode next =null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static DoubleNode revertDoubleNode(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.prev = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
