package thirtydayschallenge;

import util.TreeNode;

public class IncreasingOrderSearchTree {

    TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        dummy.right = root;
        pre = dummy;
        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);

        pre.right = root;
        root.left = null;
        pre = root;

        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node2.left = node1;
        node2.right = node4;

        node4.left = node3;

        IncreasingOrderSearchTree in = new IncreasingOrderSearchTree();
        TreeNode res1 = in.increasingBST(node2);
    }
}
