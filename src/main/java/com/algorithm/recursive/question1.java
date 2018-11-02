package com.algorithm.recursive;

/**
 * 给定整数n,返回斐波那契数第n项
 */
public class question1 {

    public static int getNum(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }

        return getNum(n - 1) + getNum(n -2);

    }

    public static void main(String[] args) {
        int num = getNum(4);
        System.out.println(num);
    }
}
