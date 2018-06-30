package com.algorithm.stack_and_queue;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Stack;

/**
 * Created by Administrator on 2018/1/31.
 * 将一个栈反转只使用递归操作
 */
public class question3 {

    public static Integer getLastAndRemove(Stack<Integer> stack){
        if (stack.size() == 1){
            return stack.pop();
        }
        Integer element = stack.pop();
        Integer lastElement = getLastAndRemove(stack);
        stack.push(element);
        return lastElement;
    }

    public static void revert(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        Integer element = getLastAndRemove(stack);
        revert(stack);
        stack.push(element);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        revert(stack);
        System.out.println(stack);
    }
}
