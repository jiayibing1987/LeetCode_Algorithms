package tree;

import util.TreeNode;

public class MaximumDifferenceBetweenNodeandAncestor {

    int res;
    public int maxAncestorDiff(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public Pair dfs(TreeNode root) {
        if(root == null)
            return null;

        Pair left = dfs(root.left);
        Pair right = dfs(root. right);

        Pair merged = mergePair(left, right);
        if(merged != null){
            res = Math.max(Math.abs(root.val - merged.min), res);
            res = Math.max(Math.abs(root.val - merged.max), res);
        } else {
            merged = new Pair(root.val);
        }
        merged.update(root.val);
        return merged;
    }

    private Pair mergePair(Pair a, Pair b) {
        if(a == null && b == null)
            return null;
        else if(a == null)
            return b;
        else if(b == null)
            return a;
        else {
            int min = Math.min(a.min, b.min);
            int max = Math.max(a.max, b.max);
            return new Pair(min, max);
        }
    }

    public class Pair {
        int min;
        int max;

        public Pair(int a) {
            min = a;
            max = a;
        }

        public Pair(int a, int b) {
            min = a;
            max = b;
        }

        public void update(int n) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);

        node1.left = node2;
        node1.right = node3;

        MaximumDifferenceBetweenNodeandAncestor m = new MaximumDifferenceBetweenNodeandAncestor();
        System.out.println(m.maxAncestorDiff(node1));

    }
}
