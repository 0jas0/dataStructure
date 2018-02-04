package com.jas.myStack;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface IStatck<T> {
    public boolean isEmpty();
    public void push(T e);
    public T pop();
    public T peek();
    public T getIndex(int index);
    public  int size();
    public void display();
}
