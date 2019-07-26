package tree;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * @author Ryan
 *
 */
public class PopulatingNextRightPointersTwo {

    public Node connect(Node root) {
        Node head = root;
        while(head != null){
        	Node nextHead = null;
        	Node lastNode = null;
        	while(head != null){
        		Node node = null;
        		for(int i=0; i<=1; i++){
        			if(i == 0) node = head.left;
        			if(i == 1) node = head.right;
        			if(node != null){
        				if(nextHead == null) nextHead = node;
        				if(lastNode != null)
        					lastNode.next = node;
        				lastNode = node;
        			}
        		}
            	head = head.next;
        	}
        	head = nextHead;
        }
    	return root;
    }
    
 // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
