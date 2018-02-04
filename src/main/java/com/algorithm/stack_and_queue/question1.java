package com.algorithm.stack_and_queue;

import java.util.Stack;

/**
 * Created by Administrator on 2018/1/31.
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小的元素
 */
public class question1 {
    private Stack<Integer> stackData = new Stack<Integer>();
    private Stack<Integer> stackMin = new Stack<Integer>();
    public void push(Integer num){
        if (stackMin.isEmpty()){
            stackMin.push(num);
        }else {
            if (stackMin.peek() >= num){
                stackMin.push(num);
            }
        }
        stackData.push(num);
    }
    public Integer pop(){
        if(stackData.isEmpty()){
            throw new RuntimeException("栈是空的");
        }
        if (stackData.peek().equals(stackMin.peek())){
            stackMin.pop();
        }
        return stackData.pop();
    }
    public Integer getMin(){
        if(stackMin.isEmpty()){
            throw new RuntimeException("栈是空的");
        }
        return stackMin.peek();
    }
}
