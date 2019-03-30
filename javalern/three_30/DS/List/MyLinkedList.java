package com.github.zjgyjd.DS.List;

public class MyLinkedList {
    /**
     * 链表中的一个节点
     */
    public class Node {
        public int value;    //要保存的数据
        public Node next;   //下一个节点线索

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;      //报存第一个节点引用,如果一个没有就等于null

    MyLinkedList() {
        this.head = null;
    }

    //O(1)

    /**
     * 头插法
     *
     * @param item
     */
    void pushFront(int item) {
        Node node = new Node(item);
        node.next = this.head;
        this.head = node;
    }

    //O(1)

    /**
     * 头删除
     */
    void popFront() {
        if (this.head == null) {
            throw new Error();
        }
        this.head = this.head.next;
    }


    /**
     * 寻找下一个
     * O(n)
     *
     * @return
     */
    private Node getLast() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 尾插
     * O(n)
     *
     * @param item
     */
    public void pushBack(int item) {
        Node node = new Node(item);
        if (this.head == null) {
            this.head = node;
        } else {
            //找到当前最后一个
            Node cur = getLast();
            //插入值
            cur.next = node;
        }
    }

    /**
     * 寻找到了倒数第二个
     *
     * @return
     */
    private Node getLastLast() {
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }

        return cur;
    }

    /**
     * 尾删
     * O(n)
     */
    public void popBack() {
        if (this.head == null) {
            throw new Error();
        }

        if (this.head.next == null) {
            this.head = null;
        } else {
            Node cur = this.getLastLast();
            cur.next = null;
        }
    }

    public void pushFront(Node node) {
        node.next = head;
        this.head = node;
    }

    public void pushBack(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = getLast();
            cur.next = node;
        }
    }
}
