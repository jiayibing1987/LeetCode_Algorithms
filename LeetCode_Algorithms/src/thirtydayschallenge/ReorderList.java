package thirtydayschallenge;

import util.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow .next;
            fast = fast.next.next;
        }

        ListNode cur = slow;
        ListNode pre = null;
        ListNode next;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode firstHead = head;
        ListNode secondHead = pre;
        ListNode firstNext;
        ListNode secondNext;
        while(firstHead.next != null && secondHead.next != null) {
            firstNext = firstHead.next;
            secondNext = secondHead.next;
            firstHead.next = secondHead;
            secondHead.next = firstNext;
            firstHead = firstNext;
            secondHead = secondNext;
        }
    }

}
