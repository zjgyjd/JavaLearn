package com.github.zjgyjd.DS.BinaryTree;

public class HashBuckets {
    private static class Node{
        int key;
        int value;
        Node next = null;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }

        Node(int key, int value){
            this.key = key;
            this.value =value;
        }
    }
    private Node[] buckets = null;
    private int size = 0;

    public HashBuckets(){
        buckets = new Node[11];
        size = 0;
    }

    public int get(int key){
        int index = key % buckets.length;
        Node node =  buckets[index];
        while(node != null){
            if(node.key == key){
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public boolean insert(int key,int value){
        int index = (key % buckets.length);
        Node head = buckets[index];
        for(Node node = head;node != null;node = node.next){
            if(node.key == key){
                return false;
            }
        }
        Node newNode = new Node(key,value);
        newNode.next = head;
        buckets[index] = newNode;
        size++;
        return true;
    }
}
