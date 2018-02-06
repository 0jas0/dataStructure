package com.algorithm.linked_list;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/5.
 * 打印出两个有序单链表中公共的部分
 * 顺序为大到小
 *
 */
public class question1 {

    public List<Integer> getCommon(SignNode head1,SignNode head2){
        List<Integer> list = new LinkedList<Integer>();
        while (head1!=null && head2!=null){
            if (head1.num > head2.num){
                head1 = head1.next;
            }else if (head1.num < head2.num){
                head2 = head2.next;
            }else {
                list.add(head1.num);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return list;
    }

}
