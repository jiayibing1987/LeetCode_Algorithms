package binarysearchtree;

import util.TreeNode;

public class KthSmallestElementBST {

    int res;
    int count = 1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs (TreeNode node, int k) {
        if(node == null)
            return;
        dfs(node.left, k);

        if(count == k) {
            res = node.val;
            count++;
            return;
        }else
            count ++;
        dfs(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);


        node3.left = node1;
        node3.right = node4;
        node1.right = node2;

        KthSmallestElementBST b = new KthSmallestElementBST();
        System.out.print (b.kthSmallest(node3, 1));
/*        System.out.print(node1);
        System.out.print(node2);
        System.out.print(node3);*/
    }
}
