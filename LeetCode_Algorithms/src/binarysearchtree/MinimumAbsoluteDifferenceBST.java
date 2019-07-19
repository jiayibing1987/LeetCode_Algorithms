package binarysearchtree;

import java.util.TreeSet;

import util.TreeNode;

public class MinimumAbsoluteDifferenceBST {

	TreeSet<Integer> set = new TreeSet<Integer>();
	int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
        	return min;
        if(root.left != null)
        	getMinimumDifference(root.left);
        
        //compare with values with neighbor in set
        if(!set.isEmpty()){
        	if(set.ceiling(root.val) != null)
        		min = Math.min(min, set.ceiling(root.val) - root.val);
        	if(set.floor(root.val) != null)
        		min = Math.min(min, root.val - set.floor(root.val));
        }
        set.add(root.val);
        
        if(root.right != null)
        	getMinimumDifference(root.right);
    	
        return min;
    }

}
