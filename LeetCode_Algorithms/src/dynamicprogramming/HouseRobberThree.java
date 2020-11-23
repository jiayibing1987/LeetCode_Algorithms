package dynamicprogramming;

import util.TreeNode;

public class HouseRobberThree {

    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode node) {
        //first is  rob, second is not rob
        if(node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int rob = node.val + left[1] + right[1];

        int rob_rob = left[0] + right[0];
        int rob_notRob = left[0] + right[1];
        int notRob_rob = left[1] + right[0];
        int notRob_notRob = left[1] + right[1];

        int t1 = Math.max(rob_rob, rob_notRob);
        int t2 = Math.max(notRob_rob, notRob_notRob);
        int notRob = Math.max(t1, t2);
        return new int[]{rob, notRob};
    }
}
