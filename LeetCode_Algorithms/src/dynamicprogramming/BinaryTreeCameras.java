package dynamicprogramming;

import util.TreeNode;

public class BinaryTreeCameras {

    private int NOT_MONITORED = 0;
    private int MONITORED_NOCAM = 1;
    private int MONITORED_WITHCAM = 2;
    private int res = 0;

    public int minCameraCover(TreeNode root) {
        if(root == null ) return 0;
        int top = helper(root);
        if(top == 0) return res + 1;
        return res;
    }

    public int helper(TreeNode root) {
        if(root == null)
            return MONITORED_NOCAM;

        int left = helper(root.left);
        int right = helper(root.right);

        if(left == MONITORED_NOCAM && right == MONITORED_NOCAM)
            return NOT_MONITORED;

        if(left == NOT_MONITORED || right == NOT_MONITORED) {
            res ++;
            return MONITORED_WITHCAM;
        }

        if(left == MONITORED_WITHCAM || right == MONITORED_WITHCAM) {
            return MONITORED_NOCAM;
        }

        return -1;
    }
}
