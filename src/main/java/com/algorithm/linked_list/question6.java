package com.algorithm.linked_list;

/**
 * Created by ansheng on 2018/2/5.
 * 环形单链表的约瑟夫问题
 * 输入一个环形的单链表的头结点head和报数的m
 * 返回最后生存的节点，而这个节点自己指向自己形成环
 */
public class question6 {
    public static SignNode getLastNode(SignNode head, int m){
        SignNode prev = head;
        while (prev.next != head){
            prev = prev.next;
        }
        int i = 0;
        while (prev != head){
            i++;
            if (i == m){
                i = 0;
                prev.next = head.next;
            }else {
                prev = head;
            }
            head = prev.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        SignNode head = new SignNode(1);
        SignNode cur = head;
        int i = 2;
        while (i < 6){
            cur = cur.next = new SignNode(i);
            i++;
        }
        cur.next = head;
        SignNode lastNode = getLastNode(head, 2);
        System.out.println(lastNode);
    }
}
