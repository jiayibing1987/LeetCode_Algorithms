package tree;

import util.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 * Given a non-empty binary tree, find the maximum path sum.
 * @author Ryan
 *
 */
public class BinaryTreeMaximumPathSum {

	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		int res = helper(root);
		return Math.max(res, max);
	}
	
	public int helper(TreeNode root){
		if (root == null)
			return 0;
		//post order traversal, a path can pick a left child or a right child or just parent node it self,
		//get max value of those 3 values
		int left = helper(root.left);
		int right = helper(root.right);
		int a = root.val + left;
		int b = Math.max(a, root.val + right);
		int c = Math.max(b, root.val);
		//if choose left sub tree+ right sub tree and parent node, then it is a final path, can't go up of tree
		int d = Math.max(c, root.val + left + right);
		max = Math.max(max, d);
		return c;
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(-25);
		root.right.right.left = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		System.out.println("maximum path sum is : " + b.maxPathSum(root));
	}

}
