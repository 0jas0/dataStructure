package com.jas.mySort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/6.
 */
public class fastSort {
    public static <T extends Comparable<? super T>> void fastSort(T[] arr){
        fastSort(arr,0,arr.length-1);
    }
    public static <T extends Comparable<? super T>> void fastSort(T[] arr,int low,int height){
        int start = low;
        int end = height;
        T key = arr[low];
        while(start<end){
            while(start<end && key.compareTo(arr[end])<=0){
                end--;
            }
            if(key.compareTo(arr[end])>0){
                T temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            while (start<end && key.compareTo(arr[start])>=0){
                start++;
            }
            if(key.compareTo(arr[start])<0){
                T temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
        }
        if(start>low){
            fastSort(arr,0,start-1);
        }
        if(end<height){
            fastSort(arr,end+1,height);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,1,3,6,7,5,9};
        fastSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
