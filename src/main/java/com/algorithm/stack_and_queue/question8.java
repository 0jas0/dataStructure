package com.algorithm.stack_and_queue;

import java.util.Stack;

/**
 * 给定一个整型矩阵map,其中的值只有0，1两种，求其中全是1的所有矩形区域中
 * 最大矩形区域为1的数量。
 *
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 其中，最大矩形区域有6个1返回6
 */
public class question8 {

    public static int maxRecSize(int[][] map){
        if (map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxSize = 0;
        int[] h = new int[map[0].length];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j<map[0].length; j++){
                h[j] = map[i][j] == 0 ? 0 : h[j]+1;
            }
            maxSize = Math.max(maxRecFromBottm(h), maxSize);
        }
        return maxSize;
    }

    public static int maxRecFromBottm(int[] h){
        if (h == null || h.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int maxSize = 0;
        for (int i = 0; i < h.length; i++){
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]){
                Integer height = h[stack.pop()];
                int k = stack.isEmpty() ? -1 : stack.peek();
                int width = i - 1 - k;
                int area = width * height;
                maxSize = Math.max(area , maxSize);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            Integer height = h[stack.pop()];
            int k = stack.isEmpty() ? -1 : stack.peek();
            int width = h.length - 1 - k;
            int area = width * height;
            maxSize = Math.max(area , maxSize);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[][] map = {{1,1,1,1},{0,1,1,1},{1,0,1,1},{0,1,1,1}};
        int maxSize = maxRecSize(map);
        System.out.println(maxSize);
    }

}
