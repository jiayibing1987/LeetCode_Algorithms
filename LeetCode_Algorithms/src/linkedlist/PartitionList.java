package linkedlist;

import util.ListNode;

/**
 * #86
 * @author Ryan
 *
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
    	if(head == null || head.next == null) return head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode slow = dummy;
    	ListNode fast = head;
    	ListNode pre = dummy;
    	boolean needSwap = false;
    	while(fast != null){
    		if(fast.val >= x){
    			needSwap = true;
    			pre = pre.next;
    			fast = fast.next;
    		}else{
    			if(needSwap){
    				//move mode
    				pre.next = fast.next;
    				fast.next = slow.next;
    				slow.next = fast;
    				fast = pre.next;
    				slow = slow.next;
    			}else{
        			pre = pre.next;
        			fast = fast.next;
        			slow = slow.next;
    			}
    		}
    	}
    	return dummy.next;
    }
    
    
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		PartitionList r = new PartitionList();
		ListNode head = r.partition(n1, 3);
		System.out.println(head.val);
		System.out.println(head.next.val);
		System.out.println(head.next.next.val);
		System.out.println(head.next.next.next.val);
		System.out.println(head.next.next.next.next.val);
	}

}
