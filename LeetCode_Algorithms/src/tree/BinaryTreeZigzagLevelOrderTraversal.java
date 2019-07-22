package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * @author Ryan
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root == null) return results;
        dfs(results, 0, root);
        return results;
    }
    
    public void dfs(List<List<Integer>> results, int depth, TreeNode node){
    	if(node == null) return;
    	if(depth == results.size())//get one level deeper, need to create a new list in results
    		results.add(new LinkedList<Integer>());
    	if(depth%2 == 0) results.get(depth).add(node.val);
    	else results.get(depth).add(0, node.val);;
    	
    	dfs(results, depth+1, node.left);
    	dfs(results, depth+1, node.right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
