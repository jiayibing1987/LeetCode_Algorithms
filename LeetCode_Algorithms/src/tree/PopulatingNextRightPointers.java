package tree;

/**
 * 116. Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
 * @author Ryan
 *
 */
public class PopulatingNextRightPointers {

	/*an iteration way 
	 * each level do as a linked list, linked left next to right node and last right node next to left
	 * */
    public Node connect(Node root) {
    	if(root == null) return null;
        Node head = root;
        while(head.left != null){
        	Node nextLevelHead = head.left;
        	Node lastRightNode = null;
        	while(head != null){
        		if(lastRightNode != null)
        			lastRightNode.next = head.left;
        		head.left.next = head.right;
        		lastRightNode = head.right;
        		head = head.next;
        	}
        	head = nextLevelHead;
        }	
    	return root;
    }
    
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
