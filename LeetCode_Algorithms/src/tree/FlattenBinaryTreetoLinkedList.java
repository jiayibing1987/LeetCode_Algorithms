package tree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class FlattenBinaryTreetoLinkedList {

	public void flatten(TreeNode root) {
		helper(root);
	}
	private TreeNode helper1(TreeNode root) {
		if(root == null) return null;
		if(root.left == null && root.right == null)
			return root;

		TreeNode leftHead = root.left;
		TreeNode rightHead = root.right;

		TreeNode left = helper(root.left);
		TreeNode right = helper(root.right);

		if(left != null) {
			root.right = leftHead;
			left.right = right;
			root.left = null;
		}

		return right != null ? right : left;
	}

	private TreeNode helper (TreeNode root) {
		if(root == null) return null;
		if(root.left  == null && root.right == null) return root;

		TreeNode left = root.left;
		TreeNode right = root.right;

		TreeNode leftLeaf = helper(left);
		TreeNode rightLeaf = helper(right);

		if(leftLeaf != null) {
			root.right = left;
			leftLeaf.right = right;
			root.left = null;
		}

		return rightLeaf == null ? leftLeaf : rightLeaf;
	}
    
	public static void main(String[] args) {
		FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node1.left = node2;
		node1.right = node5;

		node2.left = node3;
		node2.right = node4;

		node5.right = node6;
		f.flatten(node1);
	}

}
