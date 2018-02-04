package com.jas.myBinaryTree;

/**
 * 知道先序和中序构建数的结构
 * Created by ansheng on 2018/1/24.
 */
public class Test2 {
    private class BinaryNode{
        private Integer   element;
        private BinaryNode left;
        private BinaryNode right;
        public BinaryNode(Integer element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
    public BinaryNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    private BinaryNode reConstructBinaryTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if (preStart>=preEnd || inStart >= inEnd){
            return null;
        }
        BinaryNode root = new BinaryNode(pre[preStart],null,null);
        for (int i = inStart; i < inEnd;i++){
            if (in[i] == pre[preStart]){
                root.left = reConstructBinaryTree(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right = reConstructBinaryTree(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
            }
        }
        return  root;
    }

    public static void main(String[] args) {
        int[] pre = {5,4,2,3,7,6};
        int[] in = {2,3,4,5,6,7};
        BinaryNode binaryNode = new Test2().reConstructBinaryTree(pre, in);
        System.out.println(binaryNode);
    }
}
