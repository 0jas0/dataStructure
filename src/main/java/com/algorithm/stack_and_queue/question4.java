package com.algorithm.stack_and_queue;

import java.util.Stack;

/**
 * Created by Administrator on 2018/1/31.
 * 一个栈中元素类型为整型，想实现从栈顶到栈底的排序为由大到小，只能申请一个辅助栈实现
 */
public class question4 {
    public static void order(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()){
            Integer cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        order(stack);
        System.out.println(stack);
    }
}
