package com.algorithm.linked_list;

import java.util.Stack;

/**
 * 判断一个链表是否是回文结构
 * 1,2,2,1 true
 * 1,2,3,4 false
 * 1,2,3,2,1 true
 */
public class question7 {
    public boolean isPalindrome1(SignNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<SignNode> stack = new Stack<SignNode>();
        SignNode cur = head;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.num != stack.pop().num) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(SignNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<SignNode> stack = new Stack<SignNode>();
        SignNode cur = head;
        SignNode second = head.next.next;
        while (cur != null && second != null) {
            cur = cur.next;
            second = second.next.next;
        }
        cur = cur.next;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            if (head.num != stack.pop().num) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}

