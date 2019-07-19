package linkedlist;

import util.ListNode;

/**
 * #169
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * @author Ryan
 *
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA == null || headB == null) return null;
        //count size of two lists
    	ListNode currentA = headA;
    	int sizeA = 0;
    	while(currentA != null){
    		currentA = currentA.next;
    		sizeA++;
    	}
    	ListNode currentB = headB;
    	int sizeB = 0;
    	while(currentB != null){
    		currentB = currentB.next;
    		sizeB++;
    	}
    	//move pointer of A or B until they start as same length
    	int diff = Math.abs(sizeA - sizeB);
    	currentA = headA;
    	currentB = headB;
    	if(sizeA > sizeB){
    		int a = diff;
    		while(a>0){
    			currentA = currentA.next;
    			a--;
    		}
    	}else{
       		int b = diff;
    		while(b>0){
    			currentB = currentB.next;
    			b--;
    		}
    	}
    	ListNode intersection = null;
    	while(currentA!=null && currentB!= null){
    		if(currentA == currentB){
    			intersection = currentA;
    			break;
    		}
    		currentA = currentA.next;
    		currentB = currentB.next;
    	}
    	return intersection;
    }
    
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		//ListNode n5 = new ListNode(5);
		//ListNode n6 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		//n4.next = n5;
		//n5.next = n6;
		
		IntersectionofTwoLinkedLists r = new IntersectionofTwoLinkedLists();
		ListNode n = r.getIntersectionNode(n1, n2);
		System.out.println(n.val);
		System.out.println(n.next.val);
		System.out.println(n.next.next.val);
		System.out.println(n.next.next.next.val);
		//System.out.println(n.next.next.next.next.val);
		//System.out.println(n.next.next.next.next.next.val);
	}

}
