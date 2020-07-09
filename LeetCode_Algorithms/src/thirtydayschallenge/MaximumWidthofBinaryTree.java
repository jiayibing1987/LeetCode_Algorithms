package thirtydayschallenge;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<NodeExt> q = new LinkedList<>();
        q.add(new NodeExt(root, 0));
        int max = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            int leftMost = Integer.MAX_VALUE;
            for(int i=0; i<size; i++) {
                NodeExt nodeExt = q.poll();
                TreeNode node = nodeExt.node;
                int pos = nodeExt.pos;
                if(node.left != null) q.add(new NodeExt(node.left, 2*pos));
                if(node.right != null) q.add(new NodeExt(node.right, 2*pos+1));
                leftMost = Math.min(pos, leftMost);
                max = Math.max(max, pos - leftMost+1);
            }
        }
        return max;
    }

    class NodeExt {
        TreeNode node;
        int pos;

        public NodeExt(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

}
