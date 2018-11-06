package com.algorithm.recursive;

/**
 * 给定数据arr,arr中所有的值都为正数且不重复。每个值代表一种面值的货币，
 * 每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，求组成aim的最少货币数
 */
public class question4 {
    public static int minconins(int arr[], int aim){
        int[][] dp = new int[arr.length][aim+1];
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= aim; i++){
            dp[0][i] = max;
            if (i- arr[0] >= 0 && dp[0][i-arr[0]] != max){
                dp[0][i] = dp[0][i-arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i< arr.length; i++){
            for (int j = 1; j <= aim ; j++){
                left = max;
                if (j-arr[i] >= 0 && dp[i][j-arr[i]] != max){
                    left = dp[i][j-arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
        // 打印出数值
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j <= aim; j++){
                System.out.print(dp[i][j]+"   ");
            }
            System.out.println();
        }
        return dp[arr.length-1][aim] != max ? dp[arr.length-1][aim] : -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,1};
        int minconins = minconins(arr, 5);
        System.out.println("最少需要的张数为" + minconins);
    }
}
