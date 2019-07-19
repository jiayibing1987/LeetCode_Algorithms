package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreePreorder {

	List<Integer> list = new ArrayList<Integer>();
	// public List<Integer> preorderTraversal(TreeNode root) {
	// helper(root);
	// return list;
	// }
	//
	// private void helper(TreeNode root){
	// if(root == null)
	// return;
	// list.add(root.val);
	// helper(root.left);
	// helper(root.right);
	// }

	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null) return list;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current = null;
		s.push(root);
		
		while(!s.isEmpty()){
			current = s.pop();
			list.add(current.val);
			
			if(current.right != null) s.add(current.right);
			if(current.left != null) s.add(current.left);
		}
		
		return list;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		node1.left = node2;
		node2.right = node3;

		BinaryTreePreorder preorder = new BinaryTreePreorder();
		System.out.println(preorder.preorderTraversal(node1));

	}

}
