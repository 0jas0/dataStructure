package com.jas.myArrayList;

import java.util.Iterator;

/**
 * Created by ansheng on 2017/10/26.
 */
public class test {
    public static void main(String[] args) {
        myArrayList<Integer> list = new myArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(7);
        list.remove(1);
        list.set(0,100);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }
        System.out.printf(""+list.get(0));
    }
}
