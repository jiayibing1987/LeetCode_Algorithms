package thirtydayschallenge;

import tree.FindBottomLeftTreeValue;
import util.TreeNode;

import java.util.*;

public class VerticalOrderTraversalofaBinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<NodeExt>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        for(List<NodeExt> nodeList : map.values()) {
            Collections.sort(nodeList);
            List<Integer> newList = new ArrayList<>();
            for(NodeExt nodeExt : nodeList) {
                newList.add(nodeExt.node.val);
            }
            res.add(newList);
        }
        return res;
    }

    private void dfs(TreeNode node, int row, int col, Map<Integer, List<NodeExt>> map) {
        if(node == null) return;
        List<NodeExt> nodeList =  map.getOrDefault(col, new ArrayList<>());
        nodeList.add(new NodeExt(node, row, col));
        map.put(col, nodeList);

        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }

    class NodeExt implements Comparable<NodeExt>{
        TreeNode node;
        int row;
        int col;

        public NodeExt(TreeNode node, int x, int y) {
            this.node = node;
            this.row = x;
            this.col = y;
        }

        @Override
        public int compareTo(NodeExt nodeExt) {
            if(this.row != nodeExt.row) {
                return Integer.compare(this.row, nodeExt.row);
            } else {
                return Integer.compare(this.node.val, nodeExt.node.val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        VerticalOrderTraversalofaBinaryTree v = new VerticalOrderTraversalofaBinaryTree();
        System.out.println(v.verticalTraversal(node1));
    }
}
