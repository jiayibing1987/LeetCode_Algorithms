package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeInorder {

	List<Integer> list = new ArrayList<Integer>();

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

		TreeNode current = root;

		while (current != null || s.isEmpty() == false) {
			while (current != null) {
				s.push(current);
				current = current.left;
			}
			
			current = s.pop();
			list.add(current.val);
			current = current.right;
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
