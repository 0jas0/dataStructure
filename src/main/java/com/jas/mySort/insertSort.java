package com.jas.mySort;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/1.
 */
public class insertSort{
    /**
     * 在开始摸牌时，左手是空的，牌面朝下放在桌上。接着，一次从桌上摸起一张牌，并将它插入到左手一把牌中的正确位置上。为了找到这张牌的正确位置，要将它与手中已有的牌从右到左地进行比较。无论什么时候，左手中的牌都是排好序的。

     如果输入数组已经是排好序的话，插入排序出现最佳情况，其运行时间是输入规模的一个线性函数。如果输入数组是逆序排列的，将出现最坏情况。平均情况与最坏情况一样，其时间代价是Θ(n2)。

     也许你没有意识到，但其实你的思考过程是这样的：现在抓到一张7，把它和手里的牌从右到左依次比较，7比10小，应该再往左插，7比5大，好，就插这里。为什么比较了10和5就可以确定7的位置？为什么不用再比较左边的4和2呢？因为这里有一个重要的前提：手里的牌已经是排好序的。现在我插了7之后，手里的牌仍然是排好序的，下次再抓到的牌还可以用这个方法插入。编程对一个数组进行插入排序也是同样道理，但和插入扑克牌有一点不同，不可能在两个相邻的存储单元之间再插入一个单元，因此要将插入点之后的数据依次往后移动一个单元。
     * @param arr 数组
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void insertSort(T[] arr){
        int j;
        for(int i=1;i<arr.length;i++){
            T temp = arr[i];
            j=i;
            while(j>0&&temp.compareTo(arr[j-1])<0){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,5,6,7,2,9};
        insertSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
