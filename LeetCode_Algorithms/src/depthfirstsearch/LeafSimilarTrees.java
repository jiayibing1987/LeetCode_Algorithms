package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * #872
 * Consider all the leaves of a binary tree.  From left to right order, 
 * the values of those leaves form a leaf value sequence.
 * @author Ryan
 *
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    	List<Integer> list1 = new ArrayList<Integer>();
    	List<Integer> list2 = new ArrayList<Integer>();

    	dps(root1, list1);
    	dps(root2, list2);
    	
    	return list1.equals(list2);
    }
    
    private void dps(TreeNode node, List<Integer> list){
    	if(node == null)
    		return;
    	if(node.left == null && node.right == null){
    		list.add(node.val);
    		return;
    	}
    	
    	dps(node.left, list);
    	dps(node.right, list);
    }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
