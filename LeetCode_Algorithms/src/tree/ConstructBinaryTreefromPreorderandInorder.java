package tree;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

/**
 * #105
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * @author Ryan
 *
 */
public class ConstructBinaryTreefromPreorderandInorder {

	//In a Preorder sequence, leftmost element is the root of the tree. 
	//So we know ¡®A¡¯ is root for given sequences. By searching ¡®A¡¯ in Inorder sequence,
	//we can find out all elements on left side of ¡®A¡¯ are in left subtree and elements on right are in right subtree.
	int preIndex;
	Map<Integer, Integer> map;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length == 0) return null;
		map = new HashMap<Integer, Integer>();
		for(int i=0; i<inorder.length; i++)
			map.put(inorder[i], i);
		preIndex = 0;
	    return build(preorder, inorder, 0, inorder.length-1);
	}
	
	private TreeNode build(int[] preorder, int[] inorder, int low, int high){
		if(low>high) return null;
		TreeNode node = new TreeNode(preorder[preIndex++]);
		int rootIndex = map.get(node.val);
		
		node.left = build(preorder, inorder, low, rootIndex-1);
		node.right = build(preorder, inorder, rootIndex+1, high);
		return node;
	}
	  

	public static void main(String[] args) {
		ConstructBinaryTreefromPreorderandInorder c = new ConstructBinaryTreefromPreorderandInorder();

		int[] preorder = {1,3,2,4};
		int[] inorder = {1,2,3,4};
		TreeNode root = c.buildTree(preorder, inorder);
	}

}
