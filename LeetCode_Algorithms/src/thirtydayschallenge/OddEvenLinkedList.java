package thirtydayschallenge;

import util.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode evenHead = head.next;

        ListNode cur_odd = head;
        ListNode cur_even = head.next;
/*        Input: 1->2->3->4->5->NULL
        Output: 1->3->5->2->4->NULL*/
        while(cur_odd.next != null && cur_even.next != null) {
            cur_odd.next = cur_odd.next.next;
            cur_even.next = cur_even.next.next;
            cur_odd = cur_odd.next;
            cur_even = cur_even.next;
        }
        cur_odd.next = evenHead;
        return head;
    }
}
