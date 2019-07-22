package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * 107. Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * @author Ryan
 *
 */
public class BinaryTreeLevelOrderTraversalTwo {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root == null) return results;
        while(!q.isEmpty()){
        	int n = q.size();
        	List<Integer> temp = new ArrayList<Integer>();
        	for(int i=0; i<n; i++){
            	TreeNode node = q.peek();
        		if(node.left != null) q.add(node.left);
        		if(node.right != null) q.add(node.right);
        		temp.add(q.poll().val);
        	}
        	results.add(temp);
        }
        Collections.reverse(results);
        return results;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
