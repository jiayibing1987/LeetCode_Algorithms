package twopointer;

import java.util.HashSet;
import java.util.Set;

import util.ListNode;

/**
 * #142
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * @author Ryan
 *
 */
public class LinkedListCycleTwo {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode current = head;
        
        while(current != null){
        	if(set.contains(current)){
        		break;
        	}else{
        		set.add(current);
        		current = current.next;
        	}
        }
        return current;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
