package depthfirstsearch;

import util.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * #437 Path Sum III
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 */
public class PathSumThree {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(root, map, 0, sum);
        return count;
    }

    public void dfs(TreeNode node, Map<Integer, Integer> map, int sum , int target) {
        if(node == null) return;
        sum += node.val;
        if(map.containsKey(sum-target))
            count += map.get(sum-target);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(node.left, map, sum, target);
        dfs(node.right, map, sum, target);
        map.put(sum, map.get(sum) -1 );
    }

    public static  void main (String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(-3);

        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(11);

        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(-2);
        TreeNode n9 = new TreeNode(1);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right =n5; n3.right =n6;
        n4.left = n7; n4.right = n8; n5.right = n9;

        System.out.println(new PathSumThree().pathSum(n1, 8));
    }
}
