package com.github.zjgyjd.DS.BinaryTree;

public class BSTree {
    private static class Node{
        int key;
        //int value;    //带value为key-value模型
                        //不带是纯key
        Node left = null;
        Node right = null;
        Node(int key){
            this.key = key;
        }
    }
    Node root = null;

    private Node insertInner(Node node,int key) throws Exception {
        if(node == null){
            return new Node(key);
        }
        if(key==node.key){
            throw new Exception("key 重复了");
        }

        if(key<node.key){
            node.left = insertInner(node.left,key);
        }else {
            node.right = insertInner(node.right,key);
        }
        return node;
    }

    public void insert(int key) throws Exception {
        root = insertInner(root,key);
    }

    /**
     *
     * @param node 待查找的二叉树的根节点
     * @param key 要找的值
     * @return  找到与否
     */
    private boolean containsInner(Node node,int key){
        if(node == null){
            return false;
        }
        if(node.key==key){
            return true;
        }
        if(key<node.key){
            return containsInner(node.left,key);
        }else {
            return containsInner(node.right,key);
        }
    }
    public boolean contains(int key){
        return containsInner(root,key);
    }
    public void remove(int key){
        throw new UnsupportedOperationException("理论实现");
        /*
        * 删除节点
        * 1.叶子节点
        * 2.只有一个孩子:直接让孩子继承
        *3.两孩子
        * 替换删除法:找到左子树中最大的或右子树中最小的
        * */
    }
}
