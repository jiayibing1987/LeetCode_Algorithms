package binarysearchtree;

import util.TreeNode;

/**
 * 938. Range Sum of BST
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 */
public class RangeSumofBST {

    int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        dfs(root, L, R);
        return sum;
    }

    private void dfs (TreeNode root, int L, int R) {
        if(root == null) return;
        if(root.val <= R && root.val >= L)
            sum += root.val;
        if(root.val > L)
            dfs(root.left, L, R);
        if(root.val < R)
            dfs(root.right, L, R);
    }
}
