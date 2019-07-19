package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * @author Ryan
 *
 */
public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return preOrder(root, null, null);
	}

	public boolean preOrder(TreeNode node, Integer low, Integer high) {
		if (node == null)
			return true;
		if (low!= null && high!= null && low >= high)
			return false;
		if (low!= null && node.val <= low) 
			return false;
		if(high!= null && node.val >= high)
			return false;
		boolean isLeftValid = preOrder(node.left, low, node.val);
		boolean isRightValid = preOrder(node.right, node.val, high);
		return isLeftValid && isRightValid;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);

		node1.left = node2;
		node1.right = node3;
		ValidateBinarySearchTree v = new ValidateBinarySearchTree();
		System.out.println(v.isValidBST(node1));
	}

}
