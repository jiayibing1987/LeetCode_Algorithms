package binarysearchtree;

import util.TreeNode;

public class IncreasingOrderSearchTree {

    TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        pre = dummy;
        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        root.left = null;
        pre.right = root;
        pre = root;
        inOrder(root.right);
    }

}
