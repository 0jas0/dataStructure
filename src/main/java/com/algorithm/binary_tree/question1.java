package com.algorithm.binary_tree;

import java.util.Stack;

/**
 * 先序遍历一棵二叉树，使用递归和非递归的两种方式
 */
public class question1 {
    /**
     * 采用递归的方式遍历一棵二叉树
     * @param root
     */
    public void preOrderRecur(BinaryTree root){
        if (root == null){
            return;
        }
        System.out.println(root.value);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    /**
     * 采用非递归的方式遍历一棵二叉树
     * @param root
     */
    public void preOrderUnRecur(BinaryTree root){
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        if (root != null){
            stack.push(root);
            while (!stack.isEmpty()){
                BinaryTree binaryTree = stack.pop();
                System.out.println(binaryTree.value);
                if (binaryTree.right != null){
                    stack.push(binaryTree.right);
                }
                if (binaryTree.left != null){
                    stack.push(binaryTree.left);
                }
            }
        }
    }
}
