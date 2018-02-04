package com.jas.myLinkedList;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/10/27.
 */
public class test {
    public static void main(String[] args) {
        myLinkedList<Integer> linkedList = new myLinkedList();
        linkedList.add(1);
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }

    }
}
