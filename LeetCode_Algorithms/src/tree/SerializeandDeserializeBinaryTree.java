package tree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null)
                sb.append("null ");
            else {
                sb.append(node.val);
                sb.append(" ");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] values = data.split(" ");
        int n = values.length;
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for(int i=1; i<n; i++) {
            TreeNode parent = q.poll();
            if(!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                parent.left = left;
                q.add(left);
            }
            i++;
            if(!values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }

}
