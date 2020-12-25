package binarysearchtree;

import util.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {

    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        helper(root, p, q);
        return res;
    }

    private void helper (TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return;
        if(node.val <= Math.max(p.val, q.val) && node.val >= Math.min(p.val, q.val)) {
            if(res == null)
                res = node;
        }
        else if(node.val < p.val && node.val < q.val) {
            helper(node.right, p, q);
        } else if(node.val > p.val && node.val > q.val) {
            helper(node.left, p, q);
        }
    }

    public static void main (String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);


        //node3.left = node1;
        node1.right = node2;
        node2.right = node4;

        LowestCommonAncestorofaBinarySearchTree l = new LowestCommonAncestorofaBinarySearchTree();
        System.out.print(l.lowestCommonAncestor(node1, node2 ,node4));
    }
}
