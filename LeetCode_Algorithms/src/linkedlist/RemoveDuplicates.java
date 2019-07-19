package linkedlist;

import util.ListNode;

/**
 * #83 remove duplicate numner from a linked list
 * @author Ryan
 *
 */
public class RemoveDuplicates {
	
    public ListNode deleteDuplicates(ListNode head) {    
    	ListNode currnetNode = head;
    	while(currnetNode != null && currnetNode.next != null){
    		if(currnetNode.val == currnetNode.next.val){
    			currnetNode.next = currnetNode.next.next;
    		}
    		else
    			currnetNode = currnetNode.next;
    	}
    	return head;
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		RemoveDuplicates ml = new RemoveDuplicates();
		ListNode mergeHead = ml.deleteDuplicates(n1);
		System.out.println(mergeHead.val);
		System.out.println(mergeHead.next.val);
		System.out.println(mergeHead.next.next.val);
		System.out.println(mergeHead.next.next.next.val);
	}

}
