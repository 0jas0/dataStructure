package com.algorithm.stack_and_queue;

import java.util.Stack;

/**
 * Created by Administrator on 2018/1/31.
 * 使用两个栈实现队列的功能 add poll peek
 */
public class question2 {
    private Stack<Integer> stackPush = new Stack<Integer>();
    private Stack<Integer> stackPop = new Stack<Integer>();
    public void add(Integer num){
        stackPush.push(num);
    }
    public Integer poll(){
        if (stackPush.isEmpty() && stackPop.isEmpty()){
            throw  new RuntimeException("栈为空");
        }else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    public Integer peek(){
        if (stackPush.isEmpty() && stackPop.isEmpty()){
            throw  new RuntimeException("栈为空");
        }else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
