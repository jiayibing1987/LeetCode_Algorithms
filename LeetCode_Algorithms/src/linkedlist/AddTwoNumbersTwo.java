package linkedlist;

import util.ListNode;

/**
 * #445 Add Two Numbers II 
 * @author Ryan
 *
 */
public class AddTwoNumbersTwo {

	//get the difference of length
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
        int size1 = getSize(l1);
        int size2 = getSize(l2);
        int diff = size1 - size2;

        ListNode head = helper(l1, l2, diff);
        //check if need to increase one more digit to the head
        if(head.val >=10){
        	head.val = head.val % 10;
        	ListNode newHead = new ListNode(1);
        	newHead.next = head;
        	return newHead;
        }else{
        	return head;
        }
    }
    //Recursively add numbers from end to head
    public ListNode helper(ListNode l1, ListNode l2, int diff){
    	if(l1 == null && l2 == null){
    		return null;
    	}
    		
    	ListNode addedNode = new ListNode((diff<0 ? 0 : l1.val) + (diff>0 ? 0 : l2.val));
    	ListNode nextNode = helper(diff<0 ? l1 : l1.next, diff >0? l2 : l2.next, diff<0? ++diff : diff==0?diff : --diff);
    	if(nextNode!= null && nextNode.val >= 10){
    		addedNode.val = addedNode.val+1;
    		nextNode.val = nextNode.val % 10;
    	}
    	addedNode.next = nextNode;
    	return addedNode;
    }
    
    private int getSize(ListNode head){
    	int size = 0;
    	while(head != null){
    		size++;
    		head = head.next;
    	}
    	return size;
    }
    
	public static void main(String[] args) {
		ListNode n1 = new ListNode(7);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(3);
		
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		n5.next = n6;
		n6.next = n7;
		
		AddTwoNumbersTwo a = new AddTwoNumbersTwo();
		ListNode mergeHead = a.addTwoNumbers(n1, n5);
		System.out.println(mergeHead.val);
		System.out.println(mergeHead.next.val);
		System.out.println(mergeHead.next.next.val);
		System.out.println(mergeHead.next.next.next.val);
	}

}
