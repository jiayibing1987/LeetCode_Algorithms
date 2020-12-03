package binarysearchtree;

import util.TreeNode;

public class IncreasingOrderSearchTree {

    TreeNode pre;
    TreeNode head;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if(head == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = null;
        pre = root;
        inOrder(root.right);
    }

}
