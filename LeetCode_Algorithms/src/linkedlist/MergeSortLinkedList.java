package linkedlist;

import util.ListNode;

public class MergeSortLinkedList {
    
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        //1. find mid of list, and divide list into two halves
        //slow is the start of second half of list
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
        	pre = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        pre.next = null;//cut the link with 1st half and 2nd half 
        
        //2. sort two list
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        //merge two sorted list
       return mergeSortedList(l1, l2);
    }
	
	 
    
	private ListNode mergeSortedList(ListNode l1, ListNode l2) {
		if(l1== null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode mergedHead;
		if(l1.val < l2.val){
			mergedHead = l1;
			mergedHead.next = mergeSortedList(l1.next, l2);
		}else{
			mergedHead = l2;
			mergedHead.next = mergeSortedList(l1, l2.next);
		}
		return mergedHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
