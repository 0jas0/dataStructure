package com.jas.myLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/10/27.
 */
public  class myLinkedList<T> implements Iterable<T>{
    private int theSize;
    private static int modCount = 0;
    private Node<T> beginFlag;
    private Node<T> endFlag;
    private static class Node<T>{
        private T data;
        public  Node next;
        private Node prev;
        private Node(T d,Node<T> p,Node<T> n){
            data=d;
            next=n;
            prev=p;
        }
    }
    public myLinkedList(){
        clear();
    }
    public void clear(){
        doClear();
    }
    public int size(){
        return theSize;
    }
    public void add(T t){
        add(size(),t);
    }
    public void add(int index,T t){
        Node<T> node = getNode(index);
        Node<T> node1 = new Node<T>(t,node.prev,node);
        node1.prev.next=node1;
        node.prev=node1;
        theSize++;
        modCount++;
    }
    public void set(int index, T data){
        Node<T> node = getNode(index);
        node.data = data;
    }
    public void remove(int index){
        Node<T> node = getNode(index);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        theSize--;
        modCount++;
    }
    public void remove(Node<T> node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        theSize--;
        modCount++;
    }
    public Node<T> getNode(int index){
        return getNode(index,0,size());
    }
    public Node<T> getNode(int index ,int low,int high){
        if(index<low || index>high){
            throw  new IndexOutOfBoundsException("越界异常");
        }
        Node<T> node = null;
        if(index<size()/2){
            node =beginFlag.next;
            for(int i=0;i<index;i++){
                node = node.next;
            }
        }else {
            node = endFlag;
            for(int i=size();i>index;i--){
                node = node.prev;
            }
        }
        return node;
    }
    public void doClear(){
        beginFlag = new Node<T>(null,null,null);
        endFlag = new Node<T>(null,beginFlag,null);
        beginFlag.next = endFlag;
        theSize = 0;
        modCount++;
    }
    public Iterator<T> iterator() {
        return new myLinkedListIterator();
    }
    private class myLinkedListIterator implements Iterator<T>{

        private Node<T> current = beginFlag;
        private int expectedModCount = modCount;
        public boolean hasNext() {
            return current.next!=endFlag;
        }

        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("没有这个元素");
            }
            current = current.next;
            return current.data;
        }

        public void remove() {
            if(expectedModCount!=modCount){
                throw new IllegalStateException();
            }
            expectedModCount++;
            myLinkedList.this.remove(current);
        }
    }
}
