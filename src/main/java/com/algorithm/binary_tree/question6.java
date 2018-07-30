package com.algorithm.binary_tree;

import com.algorithm.binary_tree.BinaryTree;

import javax.xml.soap.Node;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 利用层序遍历，实现二叉树的序列化与反序列化
 */
public class question6 {
    public String SerializeByLevel(BinaryTree head){
        String res = "";
        if (head == null){
            return  "#!";
        }
        res += head.value+"!";
        Queue<BinaryTree> queue = new ConcurrentLinkedQueue<BinaryTree>();
        queue.add(head);
        while (!queue.isEmpty()){
            BinaryTree binaryTree = queue.poll();
            if (binaryTree.left != null){
                queue.add(binaryTree.left);
                res += binaryTree.value+"!";
            }else {
                res += "#!";
            }

            if (binaryTree.right != null){
                queue.add(binaryTree.right);
                res += binaryTree.value+"!";
            }else {
                res += "#!";
            }
        }
        return res;
    }

    public BinaryTree unSerializeByLevel(String str){
        if ("#!".equals(str)){
            return null;
        }
        String[] strArr = str.split("!");
        int index = 0;
        BinaryTree head = generateBinarayTree(strArr[index++]);
        Queue<BinaryTree> queue = new ConcurrentLinkedQueue<BinaryTree>();
        queue.add(head);
        while (!queue.isEmpty()){
            BinaryTree binaryTree = queue.poll();
            binaryTree.left = generateBinarayTree(strArr[index++]);
            binaryTree.right = generateBinarayTree(strArr[index++]);
            if (binaryTree.left != null){
                queue.add(binaryTree.left);
            }
            if (binaryTree.right != null){
                queue.add(binaryTree.right);
            }

        }
        return head;
    }

    private BinaryTree generateBinarayTree(String str){
        if ("#".equals(str)){
            return null;
        }
        BinaryTree binaryTree = new BinaryTree(Integer.valueOf(str));
        return binaryTree;
    }
}
