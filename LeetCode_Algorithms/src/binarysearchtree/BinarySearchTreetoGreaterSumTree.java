package binarysearchtree;

import util.TreeNode;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * @author Ryan
 *
 */
public class BinarySearchTreetoGreaterSumTree {

    public TreeNode bstToGst(TreeNode root) {
    	reverseInorder(root);
    	return root;
    }
    
    //reverse inorder search
    int currentSum = 0;
	private void reverseInorder(TreeNode node) {	
		if(node.right != null)
			reverseInorder(node.right);
		currentSum = node.val + currentSum;
		node.val = currentSum;
		if(node.left != null)
			reverseInorder(node.left);		
	}




	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);

		node1.left = node2;
		node1.right = node3;
		
		BinarySearchTreetoGreaterSumTree b = new BinarySearchTreetoGreaterSumTree();
		b.bstToGst(node1);
		System.out.print(node1);
		System.out.print(node2);		
		System.out.print(node3);
	}

}
