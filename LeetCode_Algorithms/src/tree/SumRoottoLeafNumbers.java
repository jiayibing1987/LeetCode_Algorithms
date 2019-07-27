package tree;

import util.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * @author Ryan
 *
 */
public class SumRoottoLeafNumbers {

	//solution2, not using a global variable, clean code
    public int sumNumbers(TreeNode root) {
    	return helper(root, 0);
    }
    
	private int helper(TreeNode node, int num){
		if(node == null)
			return 0;
		if(node.left == null && node.right==null)
			return num*10 + node.val;
		return helper(node.left, num*10 + node.val)
				+ helper(node.right, num*10 + node.val);
	}
	
	
	
	
	
    //solution 1 , append strings
	int sum;
    public int sumNumbers1(TreeNode root) {
    	sum = 0;
    	if(root == null) return 0;
        dfs(root, "");
        return sum;
    }
    
    //pre-order 
    private void dfs (TreeNode node, String s){
    	if(node.left == null && node.right == null)
    		sum += Integer.valueOf(s+String.valueOf(node.val));
    	if(node.left != null) dfs(node.left, s+String.valueOf(node.val));
    	if(node.right != null) dfs(node.right, s+String.valueOf(node.val));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
