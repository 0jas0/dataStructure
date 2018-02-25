package com.algorithm.linked_list;

import java.util.Stack;

/**
 * 两个单链表生成相加链表
 * 加上每个节点的值为0～9之间，那么链表整体就可以代表一个整数
 * 给定两个这种链表的头节点head1和head2,请生成代表两个整数相加值的结果链表
 * eg:链表1为 9->3->7,链表2为 6->3,最后生成新的结果链表为 1->0->0->0
 */
public class question10 {
    public static SignNode addList1(SignNode head1, SignNode head2){
        Stack<SignNode> stack1 = new Stack<SignNode>();
        Stack<SignNode> stack2 = new Stack<SignNode>();
        SignNode cur1 = head1;
        SignNode cur2 = head2;
        while (cur1 != null){
            stack1.push(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null){
            stack2.push(cur2);
            cur2 = cur2.next;
        }
        int n1 = 0;
        int n2 = 0;
        int bus = 0;
        int n = 0;
        SignNode pre = null;
        SignNode cur = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            n1 = stack1.isEmpty() ? 0 : stack1.pop().num;
            n2 = stack2.isEmpty() ? 0 : stack2.pop().num;
            n = n1 + n2 + bus;
            bus = n/10;
            cur = new SignNode(n % 10);
            cur.next = pre;
            pre = cur;
        }
        if (bus == 1){
            cur = new SignNode(1);
            cur.next = pre;
        }
        return cur;
    }
    public static SignNode addList2(SignNode head1, SignNode head2){
        head1 = revertList(head1);
        head2 = revertList(head2);
        SignNode cur1 = head1;
        SignNode cur2 = head2;
        int n1 = 0;
        int n2 = 0;
        int bus = 0;
        int n = 0;
        SignNode pre = null;
        SignNode cur = null;
        while (cur1 != null || cur2 != null){
            n1 = cur1 == null ? 0 : cur1.num;
            n2 = cur2 ==null ? 0 : cur2.num;
            n = n1 + n2 + bus;
            bus = n/10;
            cur = new SignNode(n%10);
            cur.next = pre;
            pre = cur;
            cur1 = cur1 != null ? cur1.next : null;
            cur2 = cur2 != null ? cur2.next : null;
        }
        if (bus == 1){
            cur = new SignNode(1);
            cur.next = pre;
        }
        revertList(head1);
        revertList(head2);
        return cur;
    }
    public static SignNode revertList(SignNode head){
        SignNode prev = null;
        SignNode next = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] num1 = {9,3,7};
        int[] num2 = {6,3};
        SignNode head1 = new SignNode(num1[0]);
        SignNode head2 = new SignNode(num2[0]);
        SignNode cur1 = head1;
        SignNode cur2 = head2;
        for (int i = 1; i < num1.length; i++){
            cur1.next = new SignNode(num1[i]);
            cur1 = cur1.next;
        }
        for (int i = 1; i < num2.length; i++){
            cur2.next = new SignNode(num2[i]);
            cur2 = cur2.next;
        }
        SignNode signNode = addList1(head1, head2);
        SignNode signNode1 = addList2(head1, head2);
        System.out.println(signNode+"----"+signNode1);
    }
}
