package com.algorithm.linked_list;

/**
 *给定一个无序的单链表的表头head,实现单链表的选择排序
 * 要求额外的空间复杂度为O(1)
 */
public class question15 {
    /**
     * 获取最小节点的前一个节点
     * @param head
     * @return
     */
    public static SignNode getSmallestPreNode(SignNode head){
        SignNode cur = head;
        SignNode pre = null;
        SignNode smallNode = cur;
        SignNode smallNodePre = null;
        while (cur != null){
            if (smallNode.num < cur.num){
                smallNodePre = pre;
                smallNode = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallNodePre;
    }
    public static SignNode selectSort(SignNode head){
        SignNode cur = head;
        SignNode tail = null;
        SignNode smallNode = null;
        while (cur != null){
            smallNode = cur;
            SignNode smallestPreNode = getSmallestPreNode(cur);
            if (smallestPreNode != null){
                smallNode = smallestPreNode.next;
                smallestPreNode.next = smallNode.next;
            }
            if (tail == null){
                head = smallNode;
            }else {
                tail.next = smallNode;
            }
            tail = smallNode;
            cur = cur == smallNode ? cur.next : cur;
        }
        return head;
    }
}
