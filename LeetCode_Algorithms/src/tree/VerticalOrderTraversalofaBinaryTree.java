package tree;

import util.TreeNode;

import java.util.*;

public class VerticalOrderTraversalofaBinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Map<Integer, List<TreeNode>> x_map = new TreeMap<>();
        Map<TreeNode, Integer> y_map = new HashMap<>();
        dfs(root, x_map, y_map, 0 , 0);

        for(List<TreeNode> nodes : x_map.values()) {
            Collections.sort(nodes, new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode t1, TreeNode t2) {
                    if(y_map.get(t1) != y_map.get(t2))
                        return y_map.get(t2) - y_map.get(t1);
                    else
                        return t1.val - t2.val;
                }
            });
            List<Integer> list = new ArrayList<>();
            for(TreeNode node : nodes)
                list.add(node.val);
            res.add(list);
        }
        return res;
    }

    private void dfs(TreeNode root, Map<Integer, List<TreeNode>> x_map, Map<TreeNode, Integer> y_map, int x, int y) {
        if(root == null) return;

        List<TreeNode> list = x_map.getOrDefault(x, new ArrayList<>());
        list.add(root);
        x_map.put(x, list);
        y_map.put(root, y);

        dfs(root.left, x_map, y_map, x-1, y-1);
        dfs(root.right, x_map, y_map, x+1, y-1);
    }
}
