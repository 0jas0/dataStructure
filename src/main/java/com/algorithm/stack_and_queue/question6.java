package com.algorithm.stack_and_queue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Administrator on 2018/2/1.
 *  输入：整形数组arr,窗口大小w
 *  输出：一个长度为n-w+1的数组res,res[i]表示每种窗口状态下的最大值
 */
public class question6 {
    public static int[] getMaxWindow(int[] arr, int w){
        int[] res = new int[arr.length-w+1];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < arr.length; i++){
            while (!list.isEmpty() && arr[list.getLast()] <= arr[i]){
                list.removeLast();
            }
            list.addLast(i);
            if (list.getFirst() == i-w){
                list.removeFirst();
            }
            if (i>=w-1){
                res[i-w+1]=arr[list.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] maxWindow = getMaxWindow(arr, 3);
        System.out.println(Arrays.toString(maxWindow));
    }
}
