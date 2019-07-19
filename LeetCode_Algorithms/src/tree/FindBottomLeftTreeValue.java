package tree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/*
 * #513
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode node = null;
        
        while(!q.isEmpty()){
        	node = q.peek();
        	int size = q.size();
        	for(int i=0; i<size; i++){
        		TreeNode curr = q.poll();
        		if(curr.left != null)
        			q.add(curr.left);
        		if(curr.right != null)
        			q.add(curr.right);
        		}
        }
        
        return node.val;
    }
	
	public static void main(String[] args) {
		//10,5,15,null,null,6,20
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(20);
		
		node1.left = node2;
		node1.right = node3;
		
		node3.left = node4;
		node3.right = node5;
		
		FindBottomLeftTreeValue f = new FindBottomLeftTreeValue();
		System.out.println(f.findBottomLeftValue(node1));
	}

}
