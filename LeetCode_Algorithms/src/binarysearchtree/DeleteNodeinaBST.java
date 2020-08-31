package binarysearchtree;

import util.TreeNode;

public class DeleteNodeinaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteBSTNode(root, key);
    }

    private TreeNode deleteBSTNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val) {
            root.left = deleteBSTNode(root.left, key);
        }else if(key > root.val) {
            root.right = deleteBSTNode(root.right, key);
        } else {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(right != null) {
                attachToLeftMost(right, left);
                return right;
            } else
                return left;
        }
        return root;
    }

    private void attachToLeftMost(TreeNode right, TreeNode left) {
        if(right.left == null)
            right.left = left;
        else
            attachToLeftMost(right.left, left);
    }

    public static void main (String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);

        n5.left = n3;
        n5.right = n6;

        n3.left = n2;
        n3.right= n4;

        n6.right = n7;
        System.out.print(new DeleteNodeinaBST().deleteNode(n5, 3));
    }

}
