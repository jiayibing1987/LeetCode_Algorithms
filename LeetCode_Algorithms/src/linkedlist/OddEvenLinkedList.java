package linkedlist;

import util.ListNode;

/**
 * # 328. Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * @author Ryan
 *
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode evenHead = head.next;
    	ListNode odd = head;
    	ListNode even = head.next;
    	while(odd.next != null && even.next != null){
    		odd.next = odd.next.next;
    		even.next = even.next.next;
    		if(odd.next != null) odd = odd.next;
    		if(even.next != null) even = even.next;
    	}
    	odd.next = evenHead;
    	return head;
    }
    
    
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(4);
		n1.next.next.next.next = new ListNode(5);
		OddEvenLinkedList o = new OddEvenLinkedList();
		o.oddEvenList(n1);
	}

}
