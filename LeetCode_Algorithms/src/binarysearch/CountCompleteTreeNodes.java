package binarysearch;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/**
 * #222
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * @author Ryan
 *
 */
public class CountCompleteTreeNodes {

	//binary search
    //A complete tree is different form of perfect tree
    //need to find out which sub tree is not perfect balanced
    //compare depth of left most node and right most node, if equals, then it is a perfect tree
    //if it is perfect sub tree just return number of nodes pow(2,depth)-1
    //otherwise keeping moving down
    public int countNodes(TreeNode root) {
    	if(root == null) return 0;
    	int leftDepth = leftDepth(root);
    	int righDepth = rightDepth(root);
    	//depth of left most edge is same as right most edge, number of node is pow(2,n)-1
    	if(leftDepth == righDepth)
    		return (int) Math.pow(2.0, leftDepth)-1;
    	else
    		return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int leftDepth(TreeNode node) {
    	int leftDepth = 0;
    	while(node != null){
    		node = node.left;
    		leftDepth ++;
    	}
    	return leftDepth;
    }
    
    private int rightDepth(TreeNode node) {
    	int rightDepth = 0;
    	while(node != null){
    		node = node.right;
    		rightDepth ++;
    	}
    	return rightDepth;
    }
    
	//brute force
    public int countNodes1(TreeNode root) {
    	int count = 0;
    	if(root == null) return count;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	int size = q.size();
        	count += size;
        	for(int i=0; i<size; i++){
        		TreeNode node = q.poll();
        		if(node.left != null) q.add(node.left);
        		if(node.right != null) q.add(node.right);
        	}
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
