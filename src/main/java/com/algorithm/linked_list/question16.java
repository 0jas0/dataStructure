package com.algorithm.linked_list;

/**
 * 一个环形单链表从头节点head开始降序，同时由最后的节点指向第一个节点。给定这样一个头节点head和数字num
 * 将num生成一个节点并且插入到环形的链表中并且保证原有的排序
 */
public class question16 {
    public static SignNode insertNum(SignNode head, int num){
        SignNode node = new SignNode(num);
        SignNode cur = head.next;
        SignNode pre = head;
        while (cur != head){
            if (pre.num <= num && cur.num >= num){
                break;
            }
            cur = cur.next;
        }
        pre. next = node;
        node.next = cur;
        return  head.num > num ? node : head;
    }
}
