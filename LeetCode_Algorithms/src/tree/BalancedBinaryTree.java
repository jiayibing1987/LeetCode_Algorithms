package tree;

import util.TreeNode;

/**
 * #110 check if a bst is balanced
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author Ryan
 *
 */
public class BalancedBinaryTree {

	boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        getDepth(root);
        return isBalanced;
    }
    
    
    public int getDepth(TreeNode node){
    	if(node == null) return 0;
    	int left = getDepth(node.left);
    	int right = getDepth( node.right);
        if(Math.abs(left-right) > 1 )
        	isBalanced = false;
        return Math.max(left, right) + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
