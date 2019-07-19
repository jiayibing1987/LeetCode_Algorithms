package linkedlist;

import util.ListNode;

public class ReverseListTwo {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		ListNode pre = null;
		ListNode current = head;
		ListNode next = null;
		int i = 1;

		ListNode mNode = null;
		ListNode mPreNode = null;
		ListNode nNode = null;
		ListNode nNextNode = null;

		while (current != null) {
			next = current.next;
			if (i == m) {
				mNode = current;
				mPreNode = pre;
			}
			if (i > m && i < n) {
				current.next = pre;
			}
			if (i == n) {
				nNode = current;
				nNextNode = next;
				current.next = pre;
			}
			pre = current;
			current = next;
			i = i + 1;
		}
		mNode.next = nNextNode;
		if (mPreNode != null) {
			mPreNode.next = nNode;
			return head;
		} else {
			return nNode;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		// ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = null;
		// n3.next = null;

		ReverseListTwo r = new ReverseListTwo();
		ListNode result = r.reverseBetween(n1, 1, 2);
		System.out.println(result);
		System.out.println(result.next);
		// System.out.println(result.next.next);

	}

}
