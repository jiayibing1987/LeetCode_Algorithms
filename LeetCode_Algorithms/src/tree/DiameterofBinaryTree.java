package tree;

import util.TreeNode;

public class DiameterofBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode node){
        if(node.left == null && node.right == null) return 0;
        int left = 0;
        int right = 0;
        if(node.left != null)
            left = getDepth(node.left) + 1;
        if(node.right != null)
            right = getDepth(node.right) + 1;
        int depth = Math.max(left, right);
        max = Math.max(left+right, max);
        return  depth;
    }
}
