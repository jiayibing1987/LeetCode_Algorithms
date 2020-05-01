package thirtydayschallenge;

import util.TreeNode;

public class ValidSequencefromRoottoLeaves {

    boolean res = false;
    public boolean isValidSequence(TreeNode root, int[] arr) {
        helper(root, arr, 0);
        return res;
    }

    private void helper(TreeNode node, int[] arr, int index) {
        if(index >= arr.length || node == null || node.val != arr[index])
            return;
        if(node.left == null && node.right == null && index == arr.length -1) {
            res = true;
            return;
        }
        helper(node.left, arr, index+1);
        helper(node.right, arr, index+1);
    }
}
