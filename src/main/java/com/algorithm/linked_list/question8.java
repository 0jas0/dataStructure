package com.algorithm.linked_list;

/**
 * Created by ansheng on 2018/2/6.
 * 将一个链表按值划分为左边小，中间相等，右边大的形式
 */
public class question8 {
    public static SignNode listPartition(SignNode head, int value){
        SignNode smallStart = null;
        SignNode smallEnd = null;
        SignNode equalStart = null;
        SignNode equalEnd = null;
        SignNode bigStart = null;
        SignNode bigEnd = null;
        SignNode next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if(head.num < value){
                if (smallStart == null){
                    smallStart = head;
                    smallEnd = head;
                }else {
                    smallEnd.next = head;
                    smallEnd = smallEnd.next;
                }
            }else if(head.num == value){
                if (equalStart == null){
                    equalStart = head;
                    equalEnd = head;
                }else {
                    equalEnd.next = head;
                    equalEnd = equalEnd.next;
                }
            }else {
                if (bigStart == null){
                    bigStart = head;
                    bigEnd = head;
                }else {
                    bigEnd.next = head;
                    bigEnd = bigEnd.next;
                }
            }
            head = next;
        }
        if (smallEnd != null){
            smallEnd.next = equalStart;
            equalEnd = equalEnd == null ? smallEnd : equalEnd;
        }
        if (equalEnd != null){
            equalEnd.next = bigStart;
        }
        return smallStart == null ? equalStart == null ? bigStart :equalStart :smallStart;
    }

}
