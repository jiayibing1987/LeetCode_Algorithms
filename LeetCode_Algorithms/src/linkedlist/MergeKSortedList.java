package linkedlist;

import util.ListNode;

/**
 * #23. Merge k Sorted Lists
 * @author Ryan
 *
 */
public class MergeKSortedList {

	
	//each time find the list node with min value then attach to the mergeHead.next
//    public ListNode mergeKLists(ListNode[] lists) {
//    	if(lists == null || lists.length == 0) return null;
//    	//find the current min node in the list
//    	ListNode currentMinNode = lists[0];
//    	int currentMinIndex = 0;
//    	for(int i=1; i<lists.length; i++){
//    		if(lists[i] == null) continue;
//    		if(currentMinNode == null || lists[i].val < currentMinNode.val ){
//    			currentMinNode = lists[i];
//    			currentMinIndex = i;
//    		}
//    	}
//    	if(currentMinNode == null)
//    		return null;
//    	
//    	ListNode mergeHead;
//    	mergeHead = currentMinNode;
//    	lists[currentMinIndex] = lists[currentMinIndex].next;
//    	mergeHead.next = mergeKLists(lists);
//    	return mergeHead;
//    }
	
	//use merge sort 
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists==null || lists.length == 0) return null;
    	int start = 0;
    	int end = lists.length-1;
    	return mergeSort(lists, start, end);
    }
    
    public ListNode mergeSort(ListNode[] lists, int start, int end){
    	if(start == end)
    		return lists[start];
    	if(start < end){
    		int mid = (start + end)/2;
    		ListNode l1 = mergeSort(lists, start, mid);
    		ListNode l2 = mergeSort(lists, mid+1, end);
    		return mergeTwoLists(l1, l2);
    	}
    	return null;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	
    	ListNode mergeHead;
    	if(l1.val < l2.val){
    		mergeHead = l1;
    		mergeHead.next = mergeTwoLists(l1.next, l2);
    	}else{
    		mergeHead = l2;
    		mergeHead.next = mergeTwoLists(l1, l2.next);
    	}
    	return mergeHead;
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
