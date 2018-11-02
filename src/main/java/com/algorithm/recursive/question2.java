package com.algorithm.recursive;

/**
 * 10块钱能买多少瓶水，1块钱换一瓶，2个瓶子换一瓶水，4个盖子换一瓶水
 */
public class question2 {

    /**
     *
     * @param num 钱的数量
     * @return
     */
    public static int getBottleNum(int num){
        return getRevertBottleNum(num, num, num);
    }

    /**
     *
     * @param m 瓶子的个数
     * @param n 盖子的个数
     * @param bottleNum 钱的数量
     * @return
     */
    public static int getRevertBottleNum(int m, int n, int bottleNum){
        if (m < 2 && n < 4){
            return bottleNum;
        }
        return bottleNum + getRevertBottleNum(m/2 + n/4 + m%2,m/2 + n/4 + n%4,m/2 + n/4);
    }

    public static void main(String[] args) {
        int num = getBottleNum(10);
        System.out.println("一共可以喝的瓶数：" + num);
    }

}
