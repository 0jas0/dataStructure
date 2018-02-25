package com.algorithm.linked_list;

import java.util.HashSet;
import java.util.Random;

/**
 * 删除无序列表中的重复的节点
 * eg:1->2->3->3->2->1->1->null 删除重复节点后为：1->2->3->null
 */
public class question12 {
    /**
     * 时间复杂度O(n),空间复杂度O(n)
     * @param head 单链表的头节点
     */
    public static void removeRepeatNode1(SignNode head){
        if (head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        SignNode prev = head;
        set.add(head.num);
        SignNode cur = head.next;
        SignNode next = null;
        while (cur != null){
            next = cur.next;
            if (!set.contains(cur.num)){
                set.add(cur.num);
                prev = cur;
            }else {
                prev.next = cur.next;
            }
            cur = next;
        }
    }

    /**
     * 时间复杂度为O(n^2) 空间复杂度为 O（1）
     * @param head 单链表的头节点
     */
    public static void removeRepeatNode2(SignNode head){
        SignNode cur = head;
        SignNode prev = null;
        SignNode next = null;
        while (cur != null){
            prev = cur;
            next = cur.next;
            while (next != null){
                if (cur.num == next.num){
                    prev.next = next.next;
                }else {
                    prev = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        SignNode head = new SignNode(1);
        SignNode cur = head;
        Random random = new Random();
        for (int i = 0 ; i < 10; i++){
            int nextInt = random.nextInt(5);
            cur.next = new SignNode(nextInt);
            cur = cur.next;
        }
        removeRepeatNode2(head);
        System.out.println(head);
    }
}
