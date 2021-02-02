package binarysearchtree;

import util.TreeNode;

public class TrimaBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val <= high && root.val >= low) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            return trimBST(root.right, low, high);
        }
    }


}
