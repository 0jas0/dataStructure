package com.algorithm.stack_and_queue;

import java.util.LinkedList;

/**
 * Created by ansheng on 2018/2/4.
 *  给定数组arr和整数num，共有多少个子数组满足一下情况：
 *  max(arr[i...j])-min(arr[i..j])<=num
 *  max(arr[i...j])表示 arr[i...j]中的最大值，min(arr[i..j])表示arr[i...j]中的最小值。
 */
public class question7 {
    public static int getNum(int[] arr, int num){
        int i = 0,j = 0;
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        int res = 0;
        while (i < arr.length){
            while (j < arr.length){
                while (!qmax.isEmpty() && arr[qmax.getLast()] <= arr[j]){
                    qmax.removeLast();
                }
                qmax.addLast(j);
                while (!qmin.isEmpty() && arr[qmin.getLast()] >= arr[j]){
                    qmin.removeLast();
                }
                qmin.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){
                    break;
                }
                j++;
            }
            if (qmax.getFirst() == i){
                qmax.removeFirst();
            }
            if (qmin.getFirst() == i){
                qmin.removeFirst();
            }
            res += j-i;
        }
        return res;
    }
}
