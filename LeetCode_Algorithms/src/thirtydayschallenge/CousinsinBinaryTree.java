package thirtydayschallenge;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 */
public class CousinsinBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        boolean isCousins = false;
        int depth = 0;
        int x_depth = -1;
        int y_depth = -1;
        int x_parent = -1;
        int y_parent = -1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            if(x_parent != -1 && y_parent != -1 && x_parent == y_parent)
                return false;
            if(x_depth != -1 && y_depth != -1 && x_depth != y_depth)
                return false;
            int size = q.size();
            for(int i= 0; i<size; i++) {
                TreeNode parent = q.poll();
                if(parent.val == x) x_depth = depth;
                if(parent.val == y) y_depth = depth;
                if(parent.left != null) {
                    q.add(parent.left);
                    x_parent = parent.left.val == x ? parent.val : x_parent;
                    y_parent = parent.left.val == y ? parent.val : y_parent;
                }
                if(parent.right != null) {
                    q.add(parent.right);
                    x_parent = parent.right.val == x ? parent.val : x_parent;
                    y_parent = parent.right.val == y ? parent.val : y_parent;
                }
            }
            depth++;
        }
        return x_depth == y_depth && x_parent != y_parent;
    }
    
}
