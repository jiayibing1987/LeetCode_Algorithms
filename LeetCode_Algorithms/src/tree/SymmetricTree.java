package tree;


import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/**
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * @author Ryan
 *
 */
public class SymmetricTree {

	//dfs in two ways
    public boolean isSymmetric1(TreeNode root) {
    	return dfs(root, root);
    }
    
    private boolean dfs (TreeNode node1, TreeNode node2){
    	if(node1 == null && node2 == null)
    		return true;
    	if(node1 == null || node2 == null)
    		return false;
    	if(node1.val != node2.val){
    		return false;
    	}
    	
    	return dfs(node1.left, node2.right) &&
    			dfs(node1.right, node2.left);
    }
    
    //bfs
    public boolean isSymmetric(TreeNode root) {
    	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    	Queue<TreeNode> q2 = new LinkedList<TreeNode>();
    	q1.add(root);
    	q2.add(root);
    	while(!q1.isEmpty() && !q2.isEmpty()){
    		TreeNode node1 = q1.poll();
    		TreeNode node2 = q2.poll();
    		if(node1 == null && node2 == null) continue;
    		if(node1 == null || node2 == null) return false;
    		if(node1.val != node2.val) return false;
    		q1.add(node1.left);
    		q1.add(node1.right);
    		q2.add(node2.right);
    		q2.add(node2.left);
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
