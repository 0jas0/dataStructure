package com.algorithm.linked_list;

/**
 * Created by Administrator on 2018/2/5.
 * 删除单链表的倒数第k个元素，和双链表的倒数第k个元素
 *
 */
public class question2 {

    public SignNode removeSignLastIndex(SignNode head, int index){
        if(head == null && index < 1){
            return head;
        }
        SignNode current = head;
        while (current != null){
            current = current.next;
            index--;
        }
        //要删除的是头节点
        if (index == 0){
            head = head.next;
        }
        if (index < 0){
            current = head;
            while (index != 0){
                current = current.next;
                index++;
            }
            current.next = current.next.next;
        }
        return head;
    }

    public DoubleNode removeDoubleLastIndex(DoubleNode head, int index){
        if (head ==null && index < 1){
            return head;
        }
        DoubleNode current = head;
        while (current != null){
            current = current.next;
            index--;
        }
        //删除的是头节点
        if (index == 0){
            head = head.next;
            head.prev = null;
        }
        if (index < 0){
            current = head;
            while (index != 0){
                current = current.next;
                index++;
            }

            current.next = current.next.next;
            DoubleNode next = current.next.next;
            current.next = next;
            if (next != null){
                next.prev = current;
            }
        }
        return head;
    }

}
