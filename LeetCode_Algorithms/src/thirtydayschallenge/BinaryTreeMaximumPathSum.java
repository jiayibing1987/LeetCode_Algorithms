package thirtydayschallenge;

import util.TreeNode;

public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       helper(root);
       return max;
    }

    private int helper(TreeNode node) {
        if(node == null)
            return 0;
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);

        int goLeft = node.val + leftSum;
        int goRight = node.val + rightSum;
        int goBoth = node.val + leftSum + rightSum;

        //a path can go left or go right or node itself
        int second_max = Math.max(node.val, Math.max(goLeft, goRight));
        //if choose both left and right node, it is a completed path and must not return this value
        int cur_max = Math.max(goBoth ,second_max);
        max = Math.max(max, cur_max);
        return second_max;
    }

    public static void main (String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        TreeNode node3 = new TreeNode(3);
        node1.right = node3;
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(node1));
    }
}
