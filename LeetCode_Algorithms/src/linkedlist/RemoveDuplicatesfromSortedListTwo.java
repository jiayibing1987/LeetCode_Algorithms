package linkedlist;

import util.ListNode;

/**
 * #82Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * @author Ryan
 *
 */
public class RemoveDuplicatesfromSortedListTwo {

    public ListNode deleteDuplicates(ListNode head) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pre = dummy;
    	ListNode current = head;
    	while(current != null ){
    		//if cur node duplicate with next node then move cur 
    		if(current.next != null && current.val == current.next.val){
    			current = current.next;
    		}else{
    			//pre.next is not current, find duplicate, and current is in the end of duplicate sequence
    			//remove all duplicate nodes
    			if(pre.next != current){
    				pre.next = current.next;
    				current = pre.next;
    			}else{
    				//no duplicate then move both pre and cur pointer
        			pre = pre.next;
        			current = current.next;
    			}
    			
    		}
    	}
    	return dummy.next;
    }
    
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		//ListNode n5 = new ListNode(5);

		
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
		
		RemoveDuplicatesfromSortedListTwo ml = new RemoveDuplicatesfromSortedListTwo();
		ListNode mergeHead = ml.deleteDuplicates(n1);
		System.out.println(mergeHead.val);
		System.out.println(mergeHead.next.val);
		System.out.println(mergeHead.next.next.val);
		System.out.println(mergeHead.next.next.next.val);
	}

}
