package com.jas.myBinaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2017/10/31.
 */
public class test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer> ();
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(6);
        System.out.println("-------------------先序------------------");
        binarySearchTree.BeforePrintTree();
        System.out.println("-------------------中序------------------");
        binarySearchTree.MidPrintTree();
        System.out.println("-------------------后序------------------");
        binarySearchTree.AfterPrintTree();
        System.out.println("-------------------层序------------------");
        binarySearchTree.LevelPrintTree();
    }
}
