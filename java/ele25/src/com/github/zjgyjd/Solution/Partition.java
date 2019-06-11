package com.github.zjgyjd.Solution;

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        ListNode p = pHead;
        ListNode pre = null;
        ListNode h1 = null;
        ListNode last = null;
        ListNode h2 = null;
        while (p != null) {
            if (p.val < x) {
                if (pre == null) {
                    pre = new ListNode(p.val);
                    h1 = pre;
                } else {
                    pre.next = new ListNode(p.val);
                    pre = pre.next;
                }
                p = p.next;
            } else {

                if (last == null) {
                    last = new ListNode(p.val);
                    h2 = last;

                } else {
                    last.next = new ListNode(p.val);
                    last = last.next;
                }
                p = p.next;
            }
        }

        if (pre != null) {
            pre.next = h2;
            return h1;
        }else {
            return h2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(6);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        ListNode s = new Partition().partition(head,2);
        while (s != null){
            System.out.println(s.val);
            s = s.next;
        }
    }
}
