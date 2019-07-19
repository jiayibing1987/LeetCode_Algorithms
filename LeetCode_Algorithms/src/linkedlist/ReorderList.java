package linkedlist;

import util.ListNode;

/**
 * #143 
 * @author Ryan
 *
 */
public class ReorderList {
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null || head.next.next == null) return ;
        //find the mid of list 	
    	ListNode slow = head;
    	ListNode fast = head;
    	ListNode slowPre= null;
    	while(fast!= null && fast.next != null){
    		slowPre = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	//last node of first half, cut the link with second 
    	slowPre.next = null;
    	//reverse the node in second half(start from slow pointer)
    	//slow is now the mid of list and start of second half
    	ListNode pre = null;
    	ListNode next = null;
    	while(slow != null){
    		next = slow.next;
    		slow.next = pre;
    		pre = slow;
    		slow = next;
    	}
    	
    	//reorder new two list
    	ListNode firstHead = head;
    	ListNode secondHead = pre;
    	ListNode firstNext = null;
    	ListNode secondNext = null;
    	while(firstHead != null && secondHead != null){
    		firstNext = firstHead.next;
    		secondNext = secondHead.next;
    		firstHead.next = secondHead;
    		if(firstNext != null) secondHead.next = firstNext;
    		firstHead = firstNext;
    		secondHead = secondNext;
    	}
    }
    
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		//ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ReorderList r = new ReorderList();
		r.reorderList(n1);
		System.out.println(n1.val);
		System.out.println(n1.next.val);
		System.out.println(n1.next.next.val);
		System.out.println(n1.next.next.next.val);
		System.out.println(n1.next.next.next.next.val);

	}

}
