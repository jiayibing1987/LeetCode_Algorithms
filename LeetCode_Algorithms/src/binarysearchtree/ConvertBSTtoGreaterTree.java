package binarysearchtree;

import util.TreeNode;

public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        inOrder(root, 0);
        return root;
    }


    private int inOrder(TreeNode node, int sum) {
        if(node == null) return sum;

        int rightSum = inOrder(node.right, sum);
        node.val = node.val + rightSum ;
        return inOrder(node.left, node.val);
    }

}
