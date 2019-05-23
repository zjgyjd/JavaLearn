package com.github.zjgyjd.DS.BinaryTree;

import java.util.function.Predicate;

public class AVLTree {
    static class Node {
        int key;
        int value;
        int height = 1;
        Node left = null;
        Node right = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root = null;

    public boolean insert(int key, int value) {
        try {
            insertInternal(root, key, value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private Node insertInternal(Node node, int key, int value) throws Exception {
        if (node == null) {
            return new Node(key, value);
        }
        if (key == node.key) {
            throw new Exception("key 重复");
        } else if (key < node.key) {
            node.left = insertInternal(node.left, key, value);
            if (height(node.left) - height(node.right) >= 2) {
                if (height(node.left.left) > height(node.left.right)) {
                    node = rightRotate(node);//右旋
                } else {
                    node.left = leftRotate(node.left);//左子树左旋
                    node = rightRotate(node);//右旋
                }
            }
        } else {
            node.right = insertInternal(node.right, key, value);
            if (height(node.right) - height(node.left) >= 2) {
                if (height(node.right.right) > height(node.right.left)) {
                    node = leftRotate(node);
                } else {
                    node.right = rightRotate(node.right);
                    node = leftRotate(node);
                }
            }
        }
        node.height = updateheight(node);
        return node;
    }

    private Node rightRotate(Node node) {
        Node oriLeft = node.left;
        node.left = oriLeft.right;
        oriLeft.right = node;
        node.height = updateheight(node);
        oriLeft.height = updateheight(oriLeft);
        return oriLeft;
    }

    private Node leftRotate(Node node) {
        Node oriRight = node.right;
        node.right = oriRight.left;
        oriRight.left = node;
        node.height = updateheight(node);
        oriRight.height = updateheight(oriRight);
        return oriRight;
    }

    private int updateheight(Node node) {
        return Math.max(height(node.left), height(node.right));
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private void inorder(Node node, Predicate<Node> tester) {
        if (node != null) {
            inorder(node.left, tester);
            if (!tester.test(node)) {
                throw new RuntimeException("key: " + node.key);
            }
            inorder(node.right, tester);
        }
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;

        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }

    public void verifyHeight() {
        inorder(root, (Node node) -> {
            int actualHeight = getHeight(node);
            return actualHeight == node.height;
        });
    }

    public void verifyBalance() {
        inorder(root, (Node node) -> {
            int differ = height(node.left) - height(node.right);
            return differ >= -1 && differ <= 1;
        });
    }

    public void verifyOrdering() {
        class Cache {
            int lastKey = Integer.MIN_VALUE;

        }
        final Cache cache = new Cache();
        inorder(root, (Node node) -> {
            boolean r = (node.key >= cache.lastKey);
            cache.lastKey = node.key;
            return r;
        });
    }

    public static void main(String[] args) {
        AVLTree tree = new
                AVLTree();
        for (int i = 1000; i >= 0; i++) {
            tree.insert(i, i);
        }
        tree.verifyOrdering();
        tree.verifyBalance();
        tree.verifyHeight();
    }
}
