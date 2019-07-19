package linkedlist;

import util.ListNode;

/**
 * #19
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * @author Ryan
 *
 */
public class RemoveNthNodeFromEndofList {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(n== 0) return head;
    	int fast = 0;    	
    	ListNode fastNode;
    	ListNode slowNode;
    	ListNode pre;
    	
    	fastNode = head;
    	slowNode = head;
    	pre = head;
    	
    	while(fastNode != null){
    		fastNode = fastNode.next;
    		fast++;
    		if(fast>n){
    			pre = slowNode;
    			slowNode = slowNode.next;
    		}
    	}
    	//remove slowNode
    	if(slowNode == head){
    		head = slowNode.next;
    	}else{
    		pre.next = slowNode.next;
    		slowNode.next = null;
    	}
    	return head;
    }

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();
		System.out.println(r.removeNthFromEnd(node1, 1));
	}

}
