package com.jas.myStack;

/**
 * Created by Administrator on 2017/10/30.
 */
public class test {
    public static void main(String[] args) {
        //平衡符号问题
        myStatck<Character> stringmyStatck = new myStatck<Character>();
        String str = "((2+3)*4+(8/4-2))";
        char[] chars = str.toCharArray();
        for(char c : chars){
            if(c!=')'){
                stringmyStatck.push(c);
            }else{
                stringmyStatck.push(c);
                Character pop = stringmyStatck.pop();
                while (pop!='('){
                    pop = stringmyStatck.pop();
                }
                stringmyStatck.push('A');
            }
        }
        System.out.print(stringmyStatck.peek());
    }
}
