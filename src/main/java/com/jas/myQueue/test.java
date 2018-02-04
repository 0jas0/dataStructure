package com.jas.myQueue;

/**
 * Created by Administrator on 2017/10/30.
 */
public class test {
    public static void main(String[] args) {
        myQueue<String> myQueue= new myQueue<String>();
        myQueue.push("aaa");
        myQueue.push("bbb");
        myQueue.push("ccc");
        myQueue.push("ddd");
        String index = myQueue.getIndex(3);
        System.out.println(index);
        myQueue.display();
    }
}
