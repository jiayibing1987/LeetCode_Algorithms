package thirtydayschallenge;

import util.ListNode;

public class DeleteNodeLinkedList {

    public void deleteNode(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while(cur != null && cur.next != null) {
            pre = cur;
            cur = cur.next;
            pre.val = cur.val;
        }
        pre.next = null;
    }

}
