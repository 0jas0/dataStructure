package com.algorithm.binary_tree;

import java.util.Stack;

/**
 * 中序遍历一棵树，采用递归和非递归两种方式
 */
public class question2 {
    /**
     * 通过递归的方式遍历一棵二叉树
     * @param root 根节点
     */
    public void inOrderRecur(BinaryTree root){
        if (root == null){
            return;
        }
        inOrderRecur(root.left);
        System.out.println(root.value);
        inOrderRecur(root.right);
    }

    /**
     * 采用非递归的方式遍历一棵二叉树
     * @param root 根节点
     */
    public void inOrderUnRecur(BinaryTree root){
        if (root != null){
            Stack<BinaryTree> stack = new Stack<BinaryTree>();
            while (!stack.isEmpty() || root != null){
                if (root != null){
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    System.out.println(root.value);
                    root = root.right;
                }
            }
        }
    }
}
