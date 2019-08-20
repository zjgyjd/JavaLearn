package com.github.zjgyjd.review.DSreview;

public class ListCase {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tem = new ListNode(-1);
        tem.next = head;
        ListNode pre = tem;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return tem.next;
    }
}
