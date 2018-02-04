package com.algorithm.stack_and_queue;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Stack;

/**
 * Created by Administrator on 2018/1/31.
 * 将一个栈反转只使用递归操作
 */
public class question3 {
    public static Integer getLastAndRemove(Stack<Integer> stack){
        Integer num = stack.pop();
        if (stack.isEmpty()){
            return num;
        }
        Integer last = getLastAndRemove(stack);
        stack.push(num);
        return last;
    }
    public static void revert(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        Integer num = getLastAndRemove(stack);
        revert(stack);
        stack.push(num);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        revert(stack);
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
