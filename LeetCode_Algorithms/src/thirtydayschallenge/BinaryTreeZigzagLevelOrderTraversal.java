package thirtydayschallenge;

import util.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while(!q.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(depth % 2 == 0)
                    temp.add(node.val);
                else
                    temp.add(0, node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            results.add(temp);
            depth++;
        }

        return results;
    }

}
