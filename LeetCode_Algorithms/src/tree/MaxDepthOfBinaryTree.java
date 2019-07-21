package tree;

import util.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * @author Ryan
 *
 */
public class MaxDepthOfBinaryTree {

	int max = 0;
    public int maxDepth1(TreeNode root) {
        maxHelper(root, 0);
        return max;
    	
    }
    
    private void maxHelper(TreeNode root, int count){
    	if(root == null){
    		max = Math.max(count, max);
    		return;
    	}
    	count++;
    	maxHelper(root.left, count);
    	maxHelper(root.right, count);
    }
    
    // if the node does not exist, simply return 0. Otherwise, return the 1+the longer distance of its subtree.
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    } 
    
    public static void main(String[] args){
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(1);
    	node1.left = node2;
    	MaxDepthOfBinaryTree m = new MaxDepthOfBinaryTree();
    	System.out.println(m.maxDepth(node1));
    }
}
