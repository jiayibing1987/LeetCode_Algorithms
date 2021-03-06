package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * #102. Binary Tree Level Order Traversal
 * Get the depth during BFS
 * @author Ryan
 *
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
       	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(root == null) return results;
    	int depth = 0;
    	dfs(results, depth, root);
    	return results;
    }
    
    private void dfs(List<List<Integer>> results, int depth, TreeNode node){
    	if(node == null) return;
    	if(depth == results.size()) results.add(new ArrayList<Integer>());
    	results.get(depth).add(node.val);
    	dfs(results, depth+1, node.left);
    	dfs(results, depth+1, node.right);
    }
	
	//create a queue to store depth of node
    public List<List<Integer>> levelOrder1(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(root == null) return results;
    	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    	Queue<Integer> q2 = new LinkedList<Integer>();
    	q1.add(root);
    	q2.add(1);
    	List<Integer> temp = new ArrayList<Integer>(); 
    	int lastDepth = 1;
    	while(!q1.isEmpty()){
    		TreeNode node = q1.poll();
    		int depth = q2.poll();
    		if(depth > lastDepth){
    			results.add(temp);
    			temp = new ArrayList<Integer>();
    			lastDepth = depth;
    		}
    		temp.add(node.val);
    		if(node.left != null){q1.add(node.left); q2.add(depth+1);}
    		if(node.right != null){q1.add(node.right); q2.add(depth+1);}
    	}
    	results.add(temp);
    	return results;
    }
    
    //bfs but use only one queue
    public List<List<Integer>> levelOrder2(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(root == null) return results;
    	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    	q1.add(root);
    	while(!q1.isEmpty()){
        	List<Integer> temp = new ArrayList<Integer>(); 
        	int n = q1.size();
        	for(int i=0; i<n; i++){
        		TreeNode node = q1.peek();
        		if(node.left != null) q1.add(node.left);
        		if(node.right != null) q1.add(node.right);
        		temp.add(node.val);
        		q1.poll();
        	}
        	results.add(temp);
    	}
    	return results;
    }
    
    
	public static void main(String[] args) {
		
	}

}
