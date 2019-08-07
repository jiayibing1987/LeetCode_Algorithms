package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

/**
 * 145. Binary Tree Postorder Traversal
 * @author Ryan
 *
 */
public class BinaryTreePostorder {

    public List<Integer> postorderTraversal(TreeNode root) {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	if(root == null) return list;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curr = null;
		s.push(root);
		
		while(!s.isEmpty()){
			curr = s.pop();
			list.addFirst(curr.val);
			
			if(curr.left != null) s.add(curr.left);
			if(curr.right != null) s.add(curr.right);
		}
		return list;
    }
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		node1.left = node2;
		node2.right = node3;

		BinaryTreePostorder postorder = new BinaryTreePostorder();
		System.out.println(postorder.postorderTraversal(node1));
	}

}
