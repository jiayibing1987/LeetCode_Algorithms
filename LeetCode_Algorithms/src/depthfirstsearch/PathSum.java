package depthfirstsearch;

import util.TreeNode;

/**
 * #112
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {	
		if(root == null)
			return false;
		return helper(root, sum, 0);
	}

	private boolean helper(TreeNode node, int sum, int currentSum){
		if(node.left == null && node.right == null){
			if(currentSum + node.val == sum)
				return true;
			else
				return false;
		}
		boolean foundLeft = false;
		boolean foundRight = false;
		if(node.left != null)
			foundLeft = helper(node.left, sum, currentSum + node.val);
		if(node.right != null)
			foundRight = helper(node.right, sum, currentSum + node.val);
		return foundLeft || foundRight;
	}
	
	
	public static void main(String[] args) {
		PathSum p = new PathSum();
		
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		
		node1.left = node2;
		node1.right = node3;
	
		System.out.println(p.hasPathSum(node1, 13));
	}

}
