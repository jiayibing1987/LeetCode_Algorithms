package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * #113
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * @author Ryan
 *
 */
public class PathSumTwo {

	List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root == null)
			return result;
		helper(root, sum, 0, new ArrayList<Integer>());
		return result;
	}


	private void helper(TreeNode node, int sum, int currentSum, List<Integer> temp){
		temp.add(node.val);
		if(node.left == null && node.right == null){
			if(currentSum + node.val == sum)
				result.add(temp);
			return;
		}
		if(node.left != null){
			helper(node.left, sum, currentSum + node.val, new ArrayList<Integer>(temp));
		}
		if(node.right != null){
			helper(node.right, sum, currentSum + node.val, new ArrayList<Integer>(temp));
		}
	}
	
	
	public static void main(String[] args) {
		PathSumTwo p = new PathSumTwo();
		
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(8);
		
		node1.left = node2;
		node1.right = node3;
	
		System.out.println(p.pathSum(node1, 13));
	}

}
