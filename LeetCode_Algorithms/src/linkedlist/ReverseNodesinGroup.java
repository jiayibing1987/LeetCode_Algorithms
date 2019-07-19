package linkedlist;

import util.ListNode;

/**
 * #25
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * @author Ryan
 *
 */
public class ReverseNodesinGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head==null) 
    		return null;
    	int count = 0;
    	ListNode curr = head;
    	while(curr != null && count<k){
    		curr = curr.next;
    		count ++;
    	}
    	if(count < k)
    		return head;
    	//reverse first k nodes
    	ListNode newHead = reverse(head, k);
    	//after reverse, head is the last node in the new list, and curr is the first node of remain list
    	head.next = reverseKGroup(curr, k);
    	return newHead;
    }
    
    private ListNode reverse(ListNode head, int k){
    	int count = 0;
    	ListNode pre = null;
    	ListNode curr = head;
    	ListNode next = null;
    	while(curr != null && count<k){
    		next = curr.next;
    		curr.next = pre;
    		pre = curr;
    		curr = next;
    		count++;
    	}
    	return pre;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
