package com.algorithm.recursive;

import java.util.Arrays;

/**
 * 给定一个矩阵m，从左上角开始，每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径最小的路径和
 *  1 3 5 9
 *  8 1 3 4
 *  5 0 6 1
 *  8 8 4 0
 */
public class question3 {

    public static int minPathSum1(int[][] arr){
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0){
            return 0;
        }
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for (int j = 1; j < col; j++){
            dp[0][j] = dp[0][j-1] + arr[0][j];
        }
        for (int i = 1; i < row; i++){
            for (int j = 1; j< col; j++){
                dp[i][j] = arr[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        int pathSum = minPathSum1(arr);
        System.out.println("最小的路径合为：" + pathSum);
    }
}
