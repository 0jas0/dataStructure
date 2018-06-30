package com.algorithm.binary_tree;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/3/1.
 */
public class question4 {
    public static String serilized(BinaryTree head){
         if (head == null){
             return "#!";
         }
         String res = head.value + "!";
         res += serilized(head.left);
         res += serilized(head.right);
         return res;
    }
    public BinaryTree unSerialized(String serializedStr){
        String[] values = serializedStr.split("!");
        Queue<String> queue = new ConcurrentLinkedQueue<String>();
        for (int i = 0; i < values.length; i++){
            queue.offer(values[i]);
        }
        return reconstructionTree(queue);
    }
    public BinaryTree reconstructionTree(Queue<String> queue){
        String value = queue.poll();
        if("#".equals(value)){
            return null;
        }
        BinaryTree head = new BinaryTree(Integer.parseInt(value));
        head.left = reconstructionTree(queue);
        head.right = reconstructionTree(queue);
        return head;
    }
}
