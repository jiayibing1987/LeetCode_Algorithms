package linkedlist;

import util.ListNode;

/**
 * #61 Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * @author Ryan
 *
 */
public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) return head;
		//count size of list
		ListNode current = head;
		int size = 0;
		while(current != null){
			current = current.next;
			size++;
		}
		if(size<=1 || k%size == 0) return head;

		//get real number that need to rotate
		//m is from left to right the number of nodes need to be shifted
		int m = size - k%size;
		current = head;
		ListNode newHead = null;
		ListNode oldLastNode = null;
		ListNode newLastNode = null;
		int i = 1;
		while(current != null){
			if(i==m){
				newLastNode = current;
				newHead = current.next;
			}
			if(current.next == null){
				oldLastNode = current;
			}
			current = current.next;
			i++;
		}
		newLastNode.next = null;
		oldLastNode.next = head;
		return newHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		RotateList r = new RotateList();
		ListNode head = r.rotateRight(n1, 2);
		System.out.println(head.val);
		System.out.println(head.next.val);
		System.out.println(head.next.next.val);
		System.out.println(head.next.next.next.val);
		System.out.println(head.next.next.next.next.val);
	}

}
