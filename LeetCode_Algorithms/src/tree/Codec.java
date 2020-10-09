package tree;

import util.TreeNode;

/**
 * 449. Serialize and Deserialize BST
 */
public class Codec {

    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        preOrder(root);
        return sb.toString();
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        sb.append(root.val).append(" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return build(data.trim().split(" "), 0, data.length() - 1);
    }

    private TreeNode build(String[] c, int start, int end) {
        if (start > end || start > c.length - 1)
            return null;
        int val = Integer.valueOf(c[start]);
        TreeNode root = new TreeNode(val);
        if (start == end) return root;

        int rightChild = start + 1;
        while (rightChild < c.length && Integer.valueOf(c[rightChild]) < val)
            rightChild++;

        root.left = build(c, start + 1, rightChild - 1);
        root.right = build(c, rightChild, end);

        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
/*        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(20);*/

        Codec ser = new Codec();
        Codec deser = new Codec();
        String tree = ser.serialize(node1);
        TreeNode ans = deser.deserialize(tree);

        System.out.println(tree);
        System.out.println(ans);
    }

}
