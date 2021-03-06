package twopointer;

import util.ListNode;

/**
 * #141
 * @author Ryan
 *
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while(fast != null && fast.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow == fast)
    			return true;
    	}
    	return false;
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		node2.next = node1;
		
		LinkedListCycle l = new LinkedListCycle();
		System.out.println(l.hasCycle(node1));
	}

}
