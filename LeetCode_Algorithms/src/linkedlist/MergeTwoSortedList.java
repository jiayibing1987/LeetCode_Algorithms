package linkedlist;

import util.ListNode;

/**
 * #21
 * @author Ryan
 *
 */
public class MergeTwoSortedList {
	
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//    	if(l1 == null)
//    		return l2;
//    	if(l2 == null)
//    		return l1;    	
//    	
//    	ListNode mergeHead ;
//    	if(l1.val < l2.val){
//    		mergeHead = l1;
//    		mergeHead.next = mergeTwoLists(l1.next, l2);
//    	}
//    	else{
//    		mergeHead = l2;
//    		mergeHead.next = mergeTwoLists(l1, l2.next);
//    	}
//    	
//		return mergeHead;
//    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;    	
	
    	ListNode dummyHead = new ListNode(0);
    	ListNode mergeHead = dummyHead;

    	while(l1 != null || l2!= null){
    		if(l1 == null){
    			mergeHead.next = l2;
    			l2 = l2.next;
    		}else if (l2 == null){
    			mergeHead.next = l1;
    			l1 = l1.next;
    		}
    		else if(l1.val <= l2.val ){
    			mergeHead.next = l1;
    			l1 = l1.next;
    		}else if(l1.val > l2.val){
    			mergeHead.next = l2;
    			l2 = l2.next;
    		}
    		mergeHead = mergeHead.next;
    	}
    	return dummyHead.next;
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		
		ListNode n11 = new ListNode(1);
		ListNode n33 = new ListNode(3);
		ListNode n44 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n4;
		
		n11.next = n33;
		n33.next = n44;
		
		MergeTwoSortedList ml = new MergeTwoSortedList();
		ListNode mergeHead = ml.mergeTwoLists(n1, n11);
		System.out.println(mergeHead.val);
		System.out.println(mergeHead.next.val);
		System.out.println(mergeHead.next.next.val);
		System.out.println(mergeHead.next.next.next.val);
		System.out.println(mergeHead.next.next.next.next.val);
		System.out.println(mergeHead.next.next.next.next.next.val);
	}

}
;