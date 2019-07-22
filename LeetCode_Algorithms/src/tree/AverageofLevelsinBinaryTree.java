package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * #637. Average of Levels in Binary Tree
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * @author Ryan
 *
 */
public class AverageofLevelsinBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> results = new ArrayList<Double>();
        if(root==null) return results;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	double sum = 0;
        	int size = q.size();
        	for(int i=0; i<size; i++){
        		TreeNode node = q.poll();
        		sum = sum + node.val;
        		if(node.left != null) q.add(node.left);
        		if(node.right != null) q.add(node.right);
        	}
        	results.add(sum/(double)size);
        }
        return results;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
