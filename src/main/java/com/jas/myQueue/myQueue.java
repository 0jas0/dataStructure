package com.jas.myQueue;

/**
 * Created by Administrator on 2017/10/30.
 */
public class myQueue<T> implements IQueue<T> {
    private Node<T> begin;
    private Node<T> end;
    private int size;
    private class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;
        public Node(T  data,Node prev,Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    public myQueue(){
        size = 0;
        begin = new Node<T>(null,null,null);
        end = new Node<T>(null,begin,null);
        begin.next=end;
    }
    public boolean isEmpty() {
        return size==0;
    }

    public void push(T e) {
        Node<T> node = new Node<T>(e, end.prev, end);
        node.prev.next = node;
        end.prev = node;
        size++;
    }

    public T pop() {
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        Node<T> node = begin.next;
        node.next.prev = begin;
        begin.next = node.next;
        return node.data;
    }

    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        return begin.next.data;
    }

    public T getIndex(int index) {
        if(index>size-1 || index<0){
            throw new IndexOutOfBoundsException("越界异常");
        }
        Node<T> temp = null;
        if(index<size/2){
            temp = begin.next;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
        }else{
            temp = end;
            for(int i=size;i>index;i--){
                temp = temp.prev;
            }
        }
        return temp.data;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node<T> temp = begin.next;
        while (temp.next != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
