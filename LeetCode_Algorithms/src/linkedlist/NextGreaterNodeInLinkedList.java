package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import util.ListNode;

/**
 * #1019
 * @author Ryan
 *
 */
public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(ListNode node = head; node != null; node = node.next){
        	list.add(node.val);
        }   
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
        	while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i)){
        		result[stack.pop()] = list.get(i);
        	}
        	stack.push(i);
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
