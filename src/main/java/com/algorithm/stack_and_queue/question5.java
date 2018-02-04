package com.algorithm.stack_and_queue;

import java.util.Stack;

/**
 * Created by Administrator on 2018/2/1.
 *  汉诺塔问题比较经典，现在修改限制不能从最左边的塔移动到最右边的塔，反之也不行。而是必须经过中间的位置
 *  求当塔有N层的时候，打印最优移动路径和最优移动步数
 */
public class question5 {
    public static int process(int num, String left, String mid, String right, String from, String to){
        if (num == 1){
            if (from.equals(mid) || to.equals(mid)){
                System.out.println("move 1 from "+ from +" to "+to);
                return 1;
            }else {
                System.out.println("move 1 from "+ from +" to mid");
                System.out.println("move 1 from mid"+" to "+to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)){
            String other = (from.equals(left) || to.equals(left)) ? right : left;
            int num1 = process(num - 1, left, mid, right, from, other);
            int num2 = 1;
            System.out.println("Move "+ num +" from "+ from + " to "+ to);
            int num3 = process(num - 1, left, mid, right, other, to);
            return num1+num2+num3;
        }else {
            int num1 = process(num - 1, left, mid, right, from, to);
            int num2 = 1;
            System.out.println("Move "+ num +" from "+ from + " to "+ mid);
            int num3 = process(num - 1, left, mid, right, to, from);
            int num4 = 1;
            System.out.println("Move "+ num +" from "+ mid + " to "+ to);
            int num5 = process(num - 1, left, mid, right, from, to);
            return num1 + num2 + num3 + num4 + num5;
        }
    }

    private enum Record{
        NO,L2M,M2L,M2R,R2M;
    }
    public static int process2(int num,String left,String mid,String right){
        Stack<Integer> ls = new Stack<Integer>();
        Stack<Integer> ms = new Stack<Integer>();
        Stack<Integer> rs = new Stack<Integer>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--){
            ls.push(i);
        }
        int step = 0;
        Record[] record = {Record.NO};
        while (rs.size() != (num + 1)){
            step += fStack2tStack(record , Record.L2M, Record.M2L, ms, ls, mid, left);
            step += fStack2tStack(record , Record.M2L, Record.L2M, ls, ms, left, mid);
            step += fStack2tStack(record , Record.R2M, Record.M2R, ms, rs, right, mid);
            step += fStack2tStack(record , Record.M2R, Record.R2M, rs, ms, right, mid);
        }
        return step;
    }
    private static int fStack2tStack(Record[] record , Record preNotAct , Record now, Stack<Integer> fStack, Stack<Integer> tStack,String fromName,String toName){
        if (record[0] != preNotAct && fStack.peek() < tStack.peek()){
            tStack.push(fStack.pop());
            record[0] = now;
            System.out.println("Move "+tStack.peek()+" from " + fromName + " to "+toName);
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int process = process(3, "left", "mid", "right", "left", "right");
        System.out.println(process);
        System.out.println("------------------------------------------");
        int process2 = process2(3, "left", "mid", "right");
        System.out.println(process2);
    }
}
