package linkedlist;

import util.ListNode;

/**
 * Insertion sort linked list
 * @author Ryan
 *
 */
public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = head;
		ListNode pre = dummy;
		ListNode insertionPointer;
		while (current != null) {
			insertionPointer = dummy;
			while (insertionPointer.next != current && current.val >= insertionPointer.next.val) {
				insertionPointer = insertionPointer.next;
			}
			if(insertionPointer.next == current){
				current = current.next;
				pre = pre.next;
			}else{
				//insert node
				ListNode next = current.next;
				current.next = insertionPointer.next;
				insertionPointer.next = current;
				pre.next = next;
				current = next;
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		//ListNode n5 = new ListNode(4);
		//ListNode n5 = new ListNode(5);

		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		//n4.next = n5;
		
		InsertionSortList ml = new InsertionSortList();
		ListNode mergeHead = ml.insertionSortList(n1);
		System.out.println(mergeHead.val);
		System.out.println(mergeHead.next.val);
		System.out.println(mergeHead.next.next.val);
		System.out.println(mergeHead.next.next.next.val);
	}

}
