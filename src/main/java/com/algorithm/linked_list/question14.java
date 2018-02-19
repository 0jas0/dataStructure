package com.algorithm.linked_list;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 将一棵二叉树转化为一个双向链表
 */
public class question14 {
    /**
     * 先把二叉树通过中序遍历放到队列中，然后再遍历队列组成一个双向链表
     * @param root
     * @return
     */
    public DoubleNode convert1(DoubleNode root){
        Queue<DoubleNode> queue = new ConcurrentLinkedQueue<DoubleNode>();
        inOrderToQueue(root, queue);
        if (queue.isEmpty()){
            return null;
        }
        DoubleNode head = queue.poll();
        DoubleNode pre = head;
        DoubleNode cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            pre.next = cur;
            cur.prev = pre;
            pre = cur;
        }
        return head;
    }
    public void inOrderToQueue(DoubleNode root, Queue<DoubleNode> queue){
        if (root == null){
            return;
        }
        inOrderToQueue(root.prev, queue);
        queue.offer(root);
        inOrderToQueue(root.next, queue);
    }
    public DoubleNode convert2(DoubleNode root){
        if (root == null){
            return null;
        }
        DoubleNode last = process(root);
        DoubleNode head = last.next;
        last.next = null;
        return head;
    }
    public DoubleNode process(DoubleNode root){
        if (root == null){
            return null;
        }
        DoubleNode leftLast = process(root.prev);
        DoubleNode rightLast = process(root.next);
        DoubleNode leftHead = leftLast != null ? leftLast.next : null;
        DoubleNode rightHead = rightLast != null ? rightLast.next : null;
        if (leftLast != null && rightLast != null){
            leftLast.next = root;
            root.prev = leftLast;
            root.next = rightHead;
            rightHead.prev = root;
            rightLast.next = leftHead;
            return rightLast;
        }else if (leftLast != null){
            root.prev = leftLast;
            leftLast.next = root;
            root.next = leftHead;
            return root;
        }else if (rightLast != null){
            root.next = rightHead;
            rightHead.prev = root;
            rightLast.next = root;
            return rightLast;
        }else {
            root.next = root;
            return root;
        }
    }
}
