package com.jas.myArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class test2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()){
            stringListIterator.next();
            int i = stringListIterator.nextIndex();
            stringListIterator.add("bb");
            int j = stringListIterator.nextIndex();
            stringListIterator.remove();
        }
        System.out.println(list);
    }
}
