package com.jas.myStack;

/**
 * Created by Administrator on 2017/10/30.
 */
public class myStatck<T> implements IStatck<T> {
    private int size;//栈的大小
    private Node<T> top;//栈顶
    private class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    public myStatck(){
        size=0;
        top = new Node<T>(null,null);
    }
    public boolean isEmpty() {
        return size()==0;
    }
    public void push(T e) {
        top.next = new Node<T>(e,top.next);
        size++;
    }

    public T pop() {
        if(isEmpty()){
            throw new RuntimeException("空栈");
        }
        Node<T> next = top.next;
        top.next = top.next.next;
        size--;
        return next.data;
    }

    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("空栈");
        }
        return top.next.data;
    }

    public T getIndex(int index) {
        if(index>size-1||index<0){
            throw new IndexOutOfBoundsException("越界异常");
        }
        Node<T>  temp = top;
        int i=0;
        while(temp!=null){
            temp = temp.next;
            if(index==i){
                break;
            }
            i++;
        }
        return temp.data;
    }

    public int size() {
        return this.size;
    }

    public void display() {
        Node<T>  temp = top;
        while(temp.next!=null){
            temp = temp.next;
            System.out.println(temp.data);
        }
    }
}
