package linkedlist;

import util.ListNode;

/**
 * #24
 * Given a linked list, swap every two adjacent nodes and return its head.
 * @author Ryan
 *
 */
public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode before = new ListNode(0);
        before.next = head;
        
        ListNode pre = before;
        ListNode first = head;
        ListNode second;
        ListNode next = null;
        while(first != null){
        	second = first.next;
        	//swap first and second node
        	if(second != null){
        		next = second.next;
        		second.next = first;
        		pre.next = second;
        		pre = first;
        		if(next == null){
        			first.next = null;
        		}
        	}else{
        		pre.next = first;
        		first.next = null;
        		break;
        	}
        	//increment to next pair
        	first = next;
        }
        return before.next;
    }
    
    public static void main(String[] args){
    	ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		SwapNodesinPairs s = new SwapNodesinPairs();
		ListNode result = s.swapPairs(n1);
		System.out.print(result + "-" + result.next + "-" + result.next.next + "-" +result.next.next.next);
		//System.out.print(result);
    }
}
