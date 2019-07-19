package linkedlist;

import util.ListNode;
/**
 * #203
 * @author Ryan
 *
 */
public class RemoveLinkedListElements {
  

	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
        ListNode current = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(current != null){
        	if(current.val == val){
        		pre.next = current.next;
        		current = current.next;
        	}else{
        		current = current.next;
        		pre = pre.next;
        	}
        }
        return dummy.next;
    }
    
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		RemoveLinkedListElements r = new RemoveLinkedListElements();
		r.removeElements(n1, 6);
		System.out.println(n1.val);
		System.out.println(n1.next.val);
		System.out.println(n1.next.next.val);
		System.out.println(n1.next.next.next.val);
		System.out.println(n1.next.next.next.next.val);
		System.out.println(n1.next.next.next.next.next.val);

	}

}
