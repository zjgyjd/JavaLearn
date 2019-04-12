package com.github.zjgyjd.Solution;

public class ListRemoveElement {

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode cur = head;
        if(head == null){
            return null;
        }

        while(cur != null){
            count++;
            cur = cur.next;
        }

        for(int i = 0; i < count/2; i++){
            head = head.next;
        }
        return head;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode per = null;
        if (head == null) {
            return head;
        }
        while (cur != null) {
            if (cur.val != val) {
                per = cur;
                cur = cur.next;
            } else {
                if (per == null) {
                    cur = cur.next;
                    head = cur;
                } else {
                    per.next = cur.next;
                    cur = cur.next;
                }
            }
        }
        if (per == null) {
            return null;
        }
        return head;
    }

}
