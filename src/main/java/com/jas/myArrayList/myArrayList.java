package com.jas.myArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ansheng on 2017/10/26.
 */
public class myArrayList<T> implements Iterable<T>{
    //定义集合的默认大小
    private static final int DEFAULT_SIZE = 10;
    //定义数组的实际大小
    private int size;
    //定义数组的实际元素
    private T[] iterms;

    public myArrayList() {
        doClear();
    }
    public int size(){
        return size;
    }

    /**
     * 清空的方法
     */
    public void doClear(){
        size = 0;
        enSureIncrease(DEFAULT_SIZE);
    }
    /**
     * 扩容的方法
     * @param newSize
     */
    public void enSureIncrease(int newSize){
        //如果扩容的大小没有实际的大那就不扩容
        if(newSize<size){
            return;
        }
        T[] old = iterms;
        iterms = (T[])new Object[newSize];
        for(int i=0;i<size;i++){
            iterms[i] = old[i];
        }
    }
    public boolean add(T t){
        add(size(),t);
        return true;
    }
    public void add(int index,T t){
        if(index<0 || index>size()){
            throw new ArrayIndexOutOfBoundsException("越界异常");
        }
        if(size == iterms.length){
            enSureIncrease(size*2);
        }
        for(int i = size();i>index;i--){
            iterms[i]=iterms[i-1];
        }
        iterms[index] = t;
        size++;
    }
    public T remove(int index){
        if(index<0 || index>size()){
            throw new ArrayIndexOutOfBoundsException("越界异常");
        }
        T t= get(index);
        for(int i = index;i<size();i++){
            iterms[i]=iterms[i+1];
        }
        size--;
        return t;
    }
    public T get(int index){
        if(index<0 || index>size()){
            throw new ArrayIndexOutOfBoundsException("越界异常");
        }
        return iterms[index];
    }
    public T set(int index,T t){
        if(index<0 || index>size()){
            throw new ArrayIndexOutOfBoundsException("越界异常");
        }
        T term = get(index);
        iterms[index] = t;
        return term;
    }
    public Iterator<T> iterator() {
        return new myIterator();
    }
    private class myIterator implements Iterator<T>{
        private int current;
        public boolean hasNext() {
            return current<size;
        }

        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("没有这样的元素");
            }
            return get(current++);
        }

        public void remove() {
            myArrayList.this.remove(--current);
        }
    }
}
