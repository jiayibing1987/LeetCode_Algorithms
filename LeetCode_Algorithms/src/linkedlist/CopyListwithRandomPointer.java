package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * #138 Copy List with Random Pointer
 * 
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 * @author Ryan
 *
 */
public class CopyListwithRandomPointer {

	// Definition for a Node.
	class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	};
	
    public Node copyRandomList(Node head) {
    	if(head == null) return null;
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while(cur != null){
        	map.put(cur, new Node());
        	cur = cur.next;
        }
        cur = head;
        while(cur != null){
        	Node cloneNode = map.get(cur);
        	cloneNode.val = cur.val;
        	cloneNode.next = map.get(cur.next);
        	cloneNode.random = map.get(cur.random);
        	cur = cur.next;
        }
        return map.get(head);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
