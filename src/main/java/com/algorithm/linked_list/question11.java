package com.algorithm.linked_list;

import java.util.Stack;

/**
 * 给定一个单链表的头节点head,实现一个调整单链表的函数,使得每个k节点之间逆序
 * 如果最后不足k则直接返回
 */
public class question11 {
    /**
     * 方法1
     * @param head
     * @param k
     * @return
     */
    public static SignNode reverseNode(SignNode head, int k){
        if (k < 2){
            return head;
        }
        Stack<SignNode> stack = new Stack<SignNode>();
        SignNode pre = null;
        SignNode next = null;
        SignNode newhead = head;
        SignNode cur = head;
        while (cur != null){
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k){
                //到达了第k个节点
                pre = resign1(stack, pre, next);
                newhead = newhead == head ? cur : newhead;
            }
            cur = next;
        }
        return newhead;
    }
    public static SignNode resign1(Stack<SignNode> stack, SignNode left, SignNode right){
        SignNode pop = stack.pop();
        SignNode cur = pop;
        if (left != null){
            left.next = cur;
        }
        SignNode next = null;
        while (!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    /**
     * 方法2
     * @param head
     * @param k
     * @return
     */
    public static SignNode reverseNode2(SignNode head, int k){
        if (k < 2){
            return head;
        }
        SignNode pre = null;
        SignNode cur = head;
        SignNode next = null;
        SignNode start = null;
        int count = 1;
        while (cur != null){
            next = cur.next;
            if (count == k){
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre, start, cur, cur.next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public static void resign2(SignNode left, SignNode start, SignNode end, SignNode right){
        SignNode pre = start;
        SignNode next = null;
        SignNode cur = start.next;
        while (cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null){
            left.next = end;
        }
        start.next = right;
    }

    public static void main(String[] args) {
        SignNode head = new SignNode(1);
        int i = 2;
        SignNode cur = head;
        while (i < 10){
            cur.next = new SignNode(i);
            cur = cur.next;
            i++;
        }
        cur.next = new SignNode(10);
        SignNode newhead = reverseNode2(head, 3);
        System.out.println(newhead);
    }
}
