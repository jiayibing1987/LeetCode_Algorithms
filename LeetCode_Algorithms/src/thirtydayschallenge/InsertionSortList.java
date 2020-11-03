package thirtydayschallenge;

import linkedlist.OddEvenLinkedList;
import util.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode next;

        //4     2   1   3
        while(cur != null) {
            boolean needMove = false;
            next = cur.next;
            ListNode pre_to = dummy;
            ListNode cur_to = dummy.next;
            while(cur_to != cur) {
                if(cur.val < cur_to.val) {
                    cur.next = cur_to;
                    pre_to.next = cur;
                    needMove = true;
                    break;
                }
                pre_to = cur_to;
                cur_to = cur_to.next;
            }
            if(needMove) {
                pre.next = next;
            }else {
                pre = cur;
            }
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(1);
        n1.next.next.next = new ListNode(3);
        //n1.next.next.next.next = new ListNode(5);
        InsertionSortList o = new InsertionSortList();
        o.insertionSortList(n1);
    }
}
