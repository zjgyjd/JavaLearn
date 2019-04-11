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

    /**
     * 链表的逆置
     */
    Node Reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = null;
        Node per = null;
        while (head != null) {
            per = cur;
            cur = head;
            head = head.next;
            cur.next = per;
        }
        return cur;
    }

    /**
     * 合并有序链表
     */
    Node Merge(Node listA, Node listB) {
        Node nB = listA;
        Node nA = listB;

        if (nA == null) return nB;
        if (nB == null) return nA;

        Node result = null;
        Node last = result;

        while (nA != null && nB != null) {
            if (nA.value <= nB.value) {
                if (result == null) {
                    result = nA;
                    last = nA;
                } else {
                    last.next = nA;
                    last = nA;
                }
                nA = nA.next;
            } else {
                if (result == null) {
                    result = nB;
                    last = nB;
                } else {
                    last.next = nB;
                    last = nB;
                }
                nB = nB.next;
            }
        }
        if (nA == null) {
            last.next = nB;
        } else {
            last.next = nA;
        }
        return result;
    }

    RNode CopyRandomList(RNode head) {
        if (head == null) {
            return null;
        }

        //1.
        RNode cur = head;
        while (cur != null) {
            RNode newNode = new RNode(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }

        //2.
        cur = head;
        while (cur != null) {
            if (cur.random == null) {
                cur.next.random = null;
            }else{
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        //3.
        RNode result = head.next;
        cur = head;
        while (cur != null) {
            RNode newNode = cur.next;
            if(cur.next.next == null){
                cur.next = null;
            }else{
            cur.next = cur.next.next;
            newNode.next = newNode.next.next;
            }
            cur = cur.next;
        }
        return result;
    }
}

class RNode {
    int val;
    RNode next;
    RNode random;

    public RNode(int val) {
        this.val = val;
    }
}