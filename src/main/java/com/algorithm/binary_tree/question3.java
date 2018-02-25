package com.algorithm.binary_tree;

import java.util.Stack;

/**
 * 采用后序的遍历方式，遍历一棵树采用递归和非递归的方式
 */
public class question3 {
    /**
     * 采用递归的方式后序遍历一棵二叉树
     * @param root
     */
    public void posOrderRecur(BinaryTree root){
        if (root == null){
            return;
        }
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.println(root.value);
    }

    /**
     * 采用非递归的方式遍历一棵二叉树的后序结果
     * @param root
     */
    public void posOrderUnRecur(BinaryTree root){
        if (root != null){
            Stack<BinaryTree> stack1 = new Stack<BinaryTree>();
            Stack<BinaryTree> stack2 = new Stack<BinaryTree>();
            stack1.push(root);
            while (!stack1.isEmpty()){
                BinaryTree binaryTree = stack1.pop();
                stack2.push(binaryTree);
                if (binaryTree.left != null){
                    stack1.push(binaryTree.left);
                }
                if (binaryTree.right != null){
                    stack1.push(binaryTree.right);
                }
            }
            while (!stack2.isEmpty()){
                BinaryTree binaryTree = stack2.pop();
                System.out.println(binaryTree.value);
            }
        }
    }
}
