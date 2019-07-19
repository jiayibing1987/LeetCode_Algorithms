package linkedlist;

import util.ListNode;


/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.
 * @author Ryan
 *
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = null;
		ListNode head = null;
		boolean inc = false;
		while(true){
			if(l1==null && l2==null && inc==false) break;
			int sum = (l1 == null? 0:l1.val) + (l2==null? 0:l2.val);
			if(inc) sum++;
			if(sum >= 10){
				sum = sum - 10;
				inc = true;
			}else
				inc = false;
			ListNode current = new ListNode(sum);
			if(head == null){
				head = current;
			}
			if(pre != null)
				pre.next = current;
			pre = current;
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		return head;
	}

	public static void main(String[] args) {
		
	}

}
