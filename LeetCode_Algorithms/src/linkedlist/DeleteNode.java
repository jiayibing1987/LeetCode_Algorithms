package linkedlist;

import util.ListNode;

/**
 * #237
 * @author Ryan
 *
 */
public class DeleteNode {
    
	public void deleteNode(ListNode node) {
		ListNode pre = null;
		ListNode current = node;
		//just change the value of node
		while(current!=null && current.next != null){
			current.val = current.next.val;
			pre = current;
			current = current.next;
		}
		pre.next = null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
