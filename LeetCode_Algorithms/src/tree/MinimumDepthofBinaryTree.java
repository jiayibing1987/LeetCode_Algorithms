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
        return 1 + (Math.min(L, R) > 0 ? Math.min(L, R) : Math.max(L, R));
    }
    
}
