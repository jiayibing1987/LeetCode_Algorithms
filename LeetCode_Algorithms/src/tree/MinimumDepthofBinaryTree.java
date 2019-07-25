package tree;

import util.TreeNode;

/**
 * 
 * 111. Minimum Depth of Binary Tree
 *
 */
public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int L = minDepth(root.left);
        int R = minDepth(root.right);
        //if nothing in left or right subtree then return depth of other tree
        if(L==0 || R==0)
        	return Math.max(L, R)+1;
        else
        	return Math.min(L, R)+1;
    }
    
}
