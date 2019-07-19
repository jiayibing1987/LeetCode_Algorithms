package twopointer;

import java.util.ArrayList;
import java.util.List;

import util.ListNode;

/**
 * #234
 * Given a singly linked list, determine if it is a palindrome.
 * @author Ryan
 *
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
    	List<Integer> list = new ArrayList<Integer>();
    	ListNode current = head;
    	while(current != null){
    		list.add(current.val);
    		current = current.next;
    	}
    	
    	List<Integer> reversedList = new ArrayList<Integer>();
    	ListNode tail = reverse(head);
    	ListNode reversedCurrent = tail;
    	while(reversedCurrent != null){
    		reversedList.add(reversedCurrent.val);
    		reversedCurrent = reversedCurrent.next;
    	}

    	return list.equals(reversedList);
    }
    
    //reverse a linked list
    private ListNode reverse(ListNode head){
    	ListNode pre = null;
    	ListNode current = head;
    	ListNode next = null;
    	
    	while(current != null){
    		//remember the next node
    		next = current.next;
    		//let current node's pointer to previous node
    		current.next = pre;
    		//move current and previous one step forward
    		pre = current;
    		current = next;
    	}
    	return pre;
    }
	
	public static void main(String[] args) {
		PalindromeLinkedList p = new PalindromeLinkedList();
		ListNode head = new ListNode(1);
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(1);
		
		head.next = first;
	//	first.next = null;
		first.next = second;
		second.next = third;
		third.next = null;
		
		System.out.println(p.isPalindrome(head));
	}

}
