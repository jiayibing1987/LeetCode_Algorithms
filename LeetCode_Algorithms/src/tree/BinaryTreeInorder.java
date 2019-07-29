package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeInorder {


	// public List<Integer> inorderTraversal(TreeNode root) {
	// helper(root);
	// return list;
	// }
	//
	// private void helper(TreeNode root){
	// if(root == null)
	// return;
	// helper(root.left);
	// list.add(root.val);
	// helper(root.right);
	// }

	// iteration
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		boolean isNewNode = true;
		s.push(root);
		
		while (!s.isEmpty()) {
			while(isNewNode && s.peek().left != null){
				s.push(s.peek().left);
			}
			TreeNode curNode = s.pop();
			list.add(curNode.val);
			if(curNode.right == null) isNewNode = false;
			else {
				s.push(curNode.right);
				isNewNode = true;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		node1.left = node2;
		node2.right = node3;

		BinaryTreeInorder inorder = new BinaryTreeInorder();
		System.out.println(inorder.inorderTraversal(node1));
	}

}
