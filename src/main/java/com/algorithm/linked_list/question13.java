package com.algorithm.linked_list;

import java.util.Stack;

/**
 * 在单链表中删除指定值的节点
 * eg:1->2->3->4->null,num = 3,链表调整后1->2->4->null
 */
public class question13 {
    /**
     * 时间复杂度为O(n),空间复杂度为O(n)
     * @param head 单链表的头节点
     * @param value 要删除的值
     */
    public static SignNode removeValue1(SignNode head, int value){
        Stack<SignNode> stack = new Stack<SignNode>();
        while (head != null){
            if (head.num != value){
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()){
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }
    /**
     * 时间复杂度为O(n),空间复杂度为O(1)
     * @param head 单链表的头节点
     * @param value 要删除的值
     */
    public static SignNode removeValue2(SignNode head, int value) {
        // 确定头节点
        while (head != null){
            if (head.num != value){
                break;
            }
            head = head.next;
        }
        SignNode cur = head.next;
        SignNode prev = head;
        SignNode next = null;
        while (cur != null){
            next = cur.next;
            if (cur.num == value){
               prev.next = next;
            }else {
                prev = cur;
            }
            cur = next;
        }
        return head;
    }

    public static void main(String[] args) {
        SignNode head = new SignNode(1);
        SignNode cur = head;
        int i = 2;
        while (i < 3){
            cur = cur.next = new SignNode(i);
            i++;
        }
        SignNode node = removeValue2(head, 2);
        System.out.println(node);
    }
}
