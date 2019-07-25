package tree;

import util.ListNode;
import util.TreeNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * @author Ryan
 *
 */
public class ConvertSortedListtoBinarySearchTree {

	//find mid of linked list with two pointers then left sub tree is from head to mid
	//and right sun tree is from mid.next to end
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
    	if(head.next == null) return new TreeNode(head.val);
    	//find the mid of current linkedlist
    	ListNode slow = head;
    	ListNode fast = head;
    	ListNode pre = new ListNode(0);
    	pre.next = head;
    	while(fast != null && fast.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    		pre = pre.next;
    	}
    	pre.next = null;
    	TreeNode node = new TreeNode(slow.val);
    	node.left = sortedListToBST(head);
    	node.right = sortedListToBST(slow.next);
    	return node;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
