package linkedlist;

import util.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
    	ListNode previous = null;
    	ListNode current = head;
    	ListNode next = null;
    	
    	while(current != null){
    		next = current.next;
    		current.next = previous;
    		previous = current;
    		current = next;
    	}
    	
    	return previous;
    }
	
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		n2.next = null;
		
		ReverseList r = new ReverseList();
		ListNode result = r.reverseList(n1);
		System.out.println(result);
		System.out.println(result.next);
	}

}
