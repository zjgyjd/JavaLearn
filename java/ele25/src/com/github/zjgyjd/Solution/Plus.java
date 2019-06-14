package com.github.zjgyjd.Solution;


import java.util.LinkedList;
import java.util.Stack;

public class Plus {
    public ListNode result = null;
    public int pre = 0;
    public int deep = 0;

    public ListNode plusBA(ListNode a,ListNode b){
        ListNode r = new ListNode(-1);
        ListNode cur = r;
        int pre = 0;
        while(a != null && b != null){
            int value = a.val + b.val + pre;
            if(value >= 10){
                pre = 1;
            }else{
                pre = 0;
            }
            cur.next = new ListNode(value % 10);
            cur = cur.next;
            a = a.next;
            b = b.next;
        }
        while(a != null){
            int value = a.val + pre;
            if(value >= 10){
                pre = 1;
            }else{
                pre = 0;
            }
            cur.next = new ListNode(value % 10);
            cur = cur.next;
            a = a.next;
        }
        while(b != null){
            int value = b.val + pre;
            if(value >= 10){
                pre = 1;
            }else{
                pre = 0;
            }
            cur.next = new ListNode(value % 10);
            cur = cur.next;
            b = b.next;
        }
        if(pre == 1){
            cur.next = new ListNode(1);
        }
        return r;
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        //正向存放
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        while (a != null) {
            stack1.push(a.val);
            a = a.next;
        }
        while (b != null) {
            stack2.push(b.val);
            b = b.next;
        }
        int pre = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            int value = stack1.pop() + stack2.pop() + pre;

            if (value >= 10) {
                pre = 1;
            } else {
                pre = 0;
            }
            result.add(value % 10);
        }

        if (!stack1.isEmpty()) {
            while(!stack1.isEmpty()){
                int value = stack1.pop() + pre;
                System.out.println(value);
                if (value >= 10) {
                    pre = 1;
                } else {
                    pre = 0;
                }
                result.add(value % 10);
            }

        } else if (!stack2.isEmpty()) {
            while(!stack2.isEmpty()){
                int value = stack2.pop() + pre;
                if (value < 10) {
                    pre = 0;
                } else {
                    pre = 1;
                }
                result.add(value % 10);
            }
        }
        if (pre == 1) {
            result.add(1);
        }
        ListNode r = null;
        while (!result.isEmpty()) {
            if (r == null) {
                r = new ListNode(result.poll());

            }else {
                ListNode t = new ListNode(result.poll());

                t.next = r;
                r = t;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        ListNode s = new ListNode(6);
        s.next = new ListNode(6);
        s.next.next = new ListNode(6);
        ListNode s2 = new ListNode(6);
        s2.next = new ListNode(6);
       s2.next.next = new ListNode(6);
        ListNode r = new Plus().plusBA(s, s2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}

