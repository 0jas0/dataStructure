package com.jas.myBinaryTree;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2017/10/31.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode root;
    private class BinaryNode{
        private T element;
        private BinaryNode left;
        private BinaryNode right;
        public BinaryNode(T element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
    public BinarySearchTree(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean contains(T t){
        return contains(t,root);
    }
    public boolean contains(T t,BinaryNode node){
        if(node == null){
            return false;
        }
        int num = t.compareTo(node.element);
        if(num>0){
            return contains(t,node.right);
        }else if(num < 0){
            return contains(t,node.left);
        }else {
            return true;
        }
    }
    public T findMax(){
        return findMax(root);
    }
    public T findMin(){
        return findMin(root);
    }
    public T findMax(BinaryNode node){
        if(node==null||node.right==null){
            return node==null?null:node.element;
        }
        return findMax(node.right);
    }
    public T findMin(BinaryNode node){
        if(node==null){
            return null;
        }
        while (node.left!=null){
            node = node.left;
        }
        return node.element;
    }
    public void insert(T t){
        root = insert(t,root);
    }
    public  BinaryNode insert(T t,BinaryNode node){
        if(node==null){
            return new BinaryNode(t,null,null);
        }
        int num = t.compareTo(node.element);
        if(num>0){
             node.right = insert(t,node.right);
        }else if(num <0){
            node.left = insert(t,node.left);
        }else {}
        return node;
    }
    public void remove(T t){
        root = remove(t,root);
    }
    public BinaryNode remove(T t,BinaryNode node){
        if(node == null){
            return null;
        }
        int num = t.compareTo(node.element);
        if(num>0){
            node.right = remove(t,node.right);
        }else if(num<0){
            node.left = remove(t,node.left);
        }else if(node.left!=null&&node.right!=null){
            T min = findMin(node.right);
            node.element = min;
            node.right=remove(min,node.right);
        }else{
            node = node.left!=null?node.left:node.right;
        }
        return node;
    }
    public void LevelPrintTree(){
        Queue<BinaryNode> queue = new LinkedBlockingQueue<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode binaryNode = queue.poll();
            System.out.println(binaryNode.element);
            if(binaryNode.left!=null){
                queue.add(binaryNode.left);
            }
            if(binaryNode.right!=null){
                queue.add(binaryNode.right);
            }
        }
    }
    public void BeforePrintTree(){
        BeforePrintTree(root);
    }
    public void MidPrintTree(){
        MidPrintTree(root);
    }
    public void AfterPrintTree(){
        AfterPrintTree(root);
    }
    public void BeforePrintTree(BinaryNode node){
        if(node==null){
            return;
        }
        System.out.println(node.element);
        BeforePrintTree(node.left);
        BeforePrintTree(node.right);
    }
    public void MidPrintTree(BinaryNode node){
        if(node==null){
            return;
        }
        MidPrintTree(node.left);
        System.out.println(node.element);
        MidPrintTree(node.right);
    }
    public void AfterPrintTree(BinaryNode node){
        if(node==null){
            return;
        }
        AfterPrintTree(node.left);
        AfterPrintTree(node.right);
        System.out.println(node.element);
    }
}
