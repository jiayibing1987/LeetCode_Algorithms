package binarysearchtree;

import util.TreeNode;

import java.util.*;

public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        if(root .left == null && root.right == null)
            return;
        inOrder(root);
        if(node1 != null && node2 == null) {
            node2 = cur;
        }
        swap(node1, node2);
    }

    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    TreeNode cur = new TreeNode(Integer.MIN_VALUE);

    TreeNode node1 = null;
    TreeNode node2 = null;
    private void inOrder(TreeNode root) {
        if(root == null) return;

        inOrder(root.left);
        cur = root;
        //when inorder traversal, should be in ascending order,
        //find first number which larger than the number behind
        if(pre.val > cur.val && node1 == null) {
            node1 = pre;
        }
        //when get first wrong order number, find the first number which is greater than it at position i,
        //then the previous number at position i-1 is the second number which in wrong order
        if(node2 == null && node1 != null && cur.val > node1.val) {
            node2 = pre;
        }
        pre = cur;
        inOrder(root.right);
    }

    Map<Integer, TreeNode> map;
    List<Integer> list;
    public void recoverTree1(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();
        helper(root);
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        TreeNode n1 = null;
        TreeNode n2 = null;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) != sortedList.get(i)) {
                if(n1 == null)
                    n1 = map.get(list.get(i));
                else if(n2 == null)
                    n2 = map.get(list.get(i));
            }
        }
        swap(n1, n2);
    }

    private void swap (TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    private void helper (TreeNode node) {
        if(node == null) return;

        helper(node.left);
        map.put(node.val, node);
        list.add(node.val);
        helper(node.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node3;
        node3.right = node2;

        new RecoverBinarySearchTree().recoverTree(node1);
    }

}
