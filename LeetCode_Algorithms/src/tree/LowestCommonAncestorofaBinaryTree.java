package tree;

import util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LowestCommonAncestorofaBinaryTree {

    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        helper(root, p, q);
        return res;
    }

    private boolean helper (TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return false;

        boolean left = helper(node.left, p, q);
        boolean right = helper(node.left, p, q);
        boolean mid = (node.val == p.val || q.val == node.val);

        boolean c1 = left && right;
        boolean c2 = left && mid;
        boolean c3 = right && mid;

        if(c1 || c2 || c3)
            res = node;

        return left || right || mid;
    }


    //parent pointer
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        int depthP = 0;
        int depthQ = 0;

        //set up parent pointer
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.val == p.val) {
                    depthP = depth;
                } else if(node.val == q.val) {
                    depthQ = depth;
                }

                if(node.left != null) {
                    queue.add(node.left);
                    map.put(node.left.val, node);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    map.put(node.right.val, node);
                }
            }
            depth++;
        }

        //move two nodes to same level
        if(depthP < depthQ) {
            q = getParentNodeByLevel(q, depthQ-depthP, map);
        } else if(depthP > depthQ) {
            p = getParentNodeByLevel(p, depthP-depthQ, map);
        }

        while(p.val != q.val) {
            p = getParentNodeByLevel(p, 1, map);
            q = getParentNodeByLevel(q, 1, map);
        }
        return p;
    }

    private TreeNode getParentNodeByLevel (TreeNode node, int level, Map<Integer, TreeNode> map) {
        TreeNode cur = node;
        while(level > 0) {
            cur = map.get(cur.val);
            level--;
        }
        return cur;
    }

}
