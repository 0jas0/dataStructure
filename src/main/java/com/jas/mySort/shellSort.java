package com.jas.mySort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/2.
 */
public class shellSort {
    /**
     * 该方法的基本思想是：先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率上比前两种方法有较大提高。
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void shellsort(T[] arr){
        for(int increament = arr.length/2;increament>0;increament/=2){
            for(int i=increament;i<arr.length;i++){
                T temp = arr[i];
                int j = i;
                while(j>=increament&&temp.compareTo(arr[j-increament])<0){
                    arr[j] = arr[j-increament];
                    j=j-increament;
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,5,6,7,2,9};
        shellsort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
