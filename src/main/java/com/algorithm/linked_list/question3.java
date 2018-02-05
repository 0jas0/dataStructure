package com.algorithm.linked_list;

/**
 * 删除中间元素
 * 1 2 删除 1
 * 1 2 3 删除 2
 * 1 2 3 4 删除2
 * 1 2 3 4 5 删除3
 */
public class question3 {
    public SignNode removeMidNode(SignNode head){
        if (head.next == null || head == null){
            return head;
        }
        if (head.next.next == null){
            head = head.next;
            return head;
        }
        SignNode prev = head;
        SignNode next = head.next.next;
        while (next != null){
            prev = prev.next;
            next = next.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }

}
