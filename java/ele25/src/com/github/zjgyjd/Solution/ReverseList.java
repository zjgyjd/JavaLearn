package com.github.zjgyjd.Solution;

import java.util.ArrayList;

public class ReverseList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ListNode next = null;
        ListNode per = null;
        //*--*--通过反建一个链表-*---*
        while(listNode != null){
            next = listNode.next;
            listNode.next = per;
            per = listNode;
            listNode = next;
        }
        /*per是反序完成的链表*/
        while(per!= null){
            temp.add(per.val);
            per = per.next;
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
