package tree;

import util.TreeNode;

import java.util.*;

public class SmallestSubtreewithalltheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;

        Map<TreeNode, TreeNode> parentPointers = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<TreeNode> temp = null;

        while(!q.isEmpty()) {
             temp = new ArrayList<>(q);
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                    parentPointers.put(node.left, node);
                }
                if(node.right != null) {
                    q.add(node.right);
                    parentPointers.put(node.right, node);
                }
            }
        }

        Set<TreeNode> set = new HashSet<>(temp);
        while(set.size() > 1) {
            set = new HashSet<>();
            for(TreeNode node : temp){
                set.add(parentPointers.get(node));
            }
            temp = new ArrayList<>(set);
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        SmallestSubtreewithalltheDeepestNodes s = new SmallestSubtreewithalltheDeepestNodes();

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        root.left = node1;
        root.right = node2;

        System.out.println(s.subtreeWithAllDeepest(root));
    }
}
