package binarysearchtree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsinTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode cur1 = root1;
        TreeNode cur2 = root2;

        while(cur1 != null || !s1.isEmpty() || cur2 != null || !s2.isEmpty()) {
            while(cur1 != null) {
                s1.push(cur1);
                cur1 = cur1.left;
            }
            while(cur2 != null) {
                s2.push(cur2);
                cur2 = cur2.left;
            }

            //only pop smaller value from the stack
            int v1 = s1.isEmpty() ? Integer.MAX_VALUE : s1.peek().val;
            int v2 = s2.isEmpty() ? Integer.MAX_VALUE : s2.peek().val;
            if(v1 <= v2 ) {
                cur1 = s1.pop();
                res.add(cur1.val);
                cur1 = cur1.right;
            } else {
                cur2 = s2.pop();
                res.add(cur2.val);
                cur2 = cur2.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        node4.left = node5;
        node4.right = node6;

        AllElementsinTwoBinarySearchTrees a = new AllElementsinTwoBinarySearchTrees();
        System.out.print(a.getAllElements(node1, node4));

    }

}
