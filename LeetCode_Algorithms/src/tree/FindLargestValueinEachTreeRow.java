package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * 
 * #515
 *
 */
public class FindLargestValueinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        List<Integer> l = new ArrayList<Integer>();
        if(root == null)
        	return l;
        
        while(!q.isEmpty()){
        	int size = q.size();
        	int max = Integer.MIN_VALUE;
        	
        	for(int i=0; i<size; i++){
        		TreeNode curr = q.poll();
        		max = Math.max(max, curr.val);
           		if(curr.left != null)
        			q.add(curr.left);
        		if(curr.right != null)
        			q.add(curr.right);
        	}
        	
        	l.add(max);
        }
        return l;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
