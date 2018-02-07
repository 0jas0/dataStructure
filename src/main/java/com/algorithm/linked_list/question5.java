package com.algorithm.linked_list;
import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by ansheng on 2018/2/5.
 * 将单链表的部分反转，from开始的部分，to结束的部分，如果不满足 0<=from<=to<=N 则返回原链表
 */
public class question5 {
    public static SignNode revertSectionSignNode(SignNode head, int from, int to){
        int length = 0;
        SignNode cur = head;
        SignNode fPre = null;
        SignNode tNext = null;
        while (cur != null){
            if (length == from-1){
                fPre = cur;
            }
            if (length == to + 1){
                tNext = cur;
            }
            cur = cur.next;
            length++;
        }
        if (from < 0 || from > to || to > length){
            return head;
        }
        SignNode prev = fPre == null ? head : fPre.next;
        cur = prev.next;
        prev.next = tNext;
        SignNode next = null;
        while (cur != tNext){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        if (fPre != null){
            fPre.next = prev;
            return head;
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
        SignNode signNode = revertSectionSignNode(head, 1, 3);
        System.out.println(signNode);
    }
}
