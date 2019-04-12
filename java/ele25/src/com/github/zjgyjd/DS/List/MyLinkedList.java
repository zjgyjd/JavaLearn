package com.github.zjgyjd.DS.List;

public class MyLinkedList {
    /**
     * 链表中的一个节点
     */
    public class ListNode {
        public int value;    //要保存的数据
        public ListNode next;   //下一个节点线索

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private ListNode head;      //报存第一个节点引用,如果一个没有就等于null

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
        ListNode listNode = new ListNode(item);
        listNode.next = this.head;
        this.head = listNode;
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
    private ListNode getLast() {
        ListNode cur = this.head;
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
        ListNode listNode = new ListNode(item);
        if (this.head == null) {
            this.head = listNode;
        } else {
            //找到当前最后一个
            ListNode cur = getLast();
            //插入值
            cur.next = listNode;
        }
    }

    /**
     * 寻找到了倒数第二个
     *
     * @return
     */
    private ListNode getLastLast() {
        ListNode cur = this.head;
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
            ListNode cur = this.getLastLast();
            cur.next = null;
        }
    }

    public void pushFront(ListNode listNode) {
        listNode.next = head;
        this.head = listNode;
    }

    public void pushBack(ListNode listNode) {
        if (this.head == null) {
            this.head = listNode;
        } else {
            ListNode cur = getLast();
            cur.next = listNode;
        }
    }

    /**
     * 链表的逆置
     */
    ListNode Reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = null;
        ListNode per = null;
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
    ListNode Merge(ListNode listA, ListNode listB) {
        ListNode nB = listA;
        ListNode nA = listB;

        if (nA == null) return nB;
        if (nB == null) return nA;

        ListNode result = null;
        ListNode last = result;

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

    /**
     * 找到x,将小的放到右边大的在左边,不改变原来顺序
     *
     * @param pHead
     * @param x
     * @return
     */
    public ListNode partition(ListNode pHead, int x) {
        ListNode cur = pHead;
        ListNode small = null;
        ListNode big = null;
        ListNode last1 = null;
        ListNode last2 = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (cur.value < x) {
                if (small == null) {
                    small = cur;
                } else {
                    last1.next = cur;
                }
                last1 = cur;
            } else {
                if (big == null) {
                    big = cur;
                } else {
                    last2.next = cur;
                }
                last2 = cur;
            }
            cur = next;
        }

        if (small == null) {
            return big;
        } else {
            last1.next = big;

        }
        return small;
    }

    /**
     * 链表有序,请删除该链表中重复的结点
     *
     * @return
     * @parm pHead
     */

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;
        ListNode cur;

        //对重复结点的处理
        if (pHead.value == pHead.next.value) {
            cur = pHead.next.next;
            //遍历到没有重复结点的位置
            while (cur != null && cur.value == pHead.value) {
                cur = cur.next;
            }
            return deleteDuplication(cur);
        }

        //该结点不重复，递归下一个结点
        cur = pHead.next;
        pHead.next = deleteDuplication(cur);
        return pHead;
    }

    /**
     * 带随机引用的链表深度复制
     *
     * @param head
     * @return
     */
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
            } else {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        //3.
        RNode result = head.next;
        cur = head;
        while (cur != null) {
            RNode newNode = cur.next;
            if (cur.next.next == null) {
                cur.next = null;
            } else {
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