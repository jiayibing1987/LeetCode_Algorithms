package thirtydayschallenge;

import util.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == val)
                pre.next = cur.next;
            else
                pre = pre.next;
            cur = cur.next;
        }
        return dummy.next;
    }

}
