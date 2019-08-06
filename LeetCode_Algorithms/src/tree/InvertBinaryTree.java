package tree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/**
 * 226. Invert Binary Tree
 * @author Ryan
 *
 */
public class InvertBinaryTree {

	//dfs
    public TreeNode invertTree1(TreeNode root) {
        if(root == null)
        	return null;
        if(root.left == null && root.right == null)
        	return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    
    //bfs
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return null;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()){
    		TreeNode cur = q.poll();
    		TreeNode left = cur.left;
    		TreeNode right = cur.right;
    		cur.left = right;
    		cur.right = left;
    		if(cur.left != null) q.add(cur.left);
    		if(cur.right != null) q.add(cur.right);
    	}
    	return root;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		
		node1.left = new TreeNode(1);
		node1.right = new TreeNode(3);
		node2.left = new TreeNode(6);
		node2.right = new TreeNode(9);
		InvertBinaryTree in = new InvertBinaryTree();
		System.out.print(in.invertTree(root));
	}

}
