package com.algorithm.binary_tree;

import javax.xml.soap.Node;

/**
 * 给定一颗二叉树的节点head, 按照如下两种标准分别实现二叉数边界实现二叉数边界的逆时针打印
 */
public class question5{
    public  void printEdge(BinaryTree head){
        if (head == null){
            return;
        }
        int height = getHeight(head, 0);
        BinaryTree[][] edgeMap = new BinaryTree[height][2];
        setEdge(head, 0 ,edgeMap);
        //打印左边的节点
        for (int i = 0; i < edgeMap.length; i++){
            System.out.println(edgeMap[i][0].value);
        }
        //打印叶子节点但不是边缘节点
        printIsLeafNotEdge(head, 0, edgeMap);
        //打印右边节点
        for (int i = edgeMap.length - 1; i >= 0; i--){
            System.out.println(edgeMap[i][1]);
        }

    }

    private int getHeight(BinaryTree head, int l){
        if (head == null){
            return 1;
        }
        return Math.max(getHeight(head.left, l + 1), getHeight(head.right, l + 1));
    }
    private void setEdge(BinaryTree head, int i, BinaryTree[][] edgeMap) {
        if (head == null){
            return;
        }
        if (edgeMap[i][0] == null){
            edgeMap[i][0] = head;
        }
        edgeMap[i][1] = head;
        setEdge(head.left, i+1, edgeMap);
        setEdge(head.right, i+1, edgeMap);
    }

    private void printIsLeafNotEdge(BinaryTree head, int l, BinaryTree[][] edgeMap){
        if (head == null){
            return;
        }
        if (head.left == null && head.right == null && edgeMap[l][0] != head && edgeMap[l][1] != head){
            System.out.println(head.value);
        }
        printIsLeafNotEdge(head.left, l+1, edgeMap);
        printIsLeafNotEdge(head.right, l+1, edgeMap);
    }

}
