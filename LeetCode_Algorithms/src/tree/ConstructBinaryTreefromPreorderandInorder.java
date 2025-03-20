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
		int n = inorder.length;
		map = new HashMap<Integer, Integer>();
		for(int i=0; i<inorder.length; i++)
			map.put(inorder[i], i);
		preIndex = 0;
	    //return build(preorder, inorder, 0, inorder.length-1);
		return helper(preorder, inorder, 0, n-1, 0, n-1);
	}
	
	private TreeNode build(int[] preorder, int[] inorder, int low, int high){
		if(low>high) return null;
		TreeNode node = new TreeNode(preorder[preIndex++]);
		int rootIndex = map.get(node.val);
		
		node.left = build(preorder, inorder, low, rootIndex-1);
		node.right = build(preorder, inorder, rootIndex+1, high);
		return node;
	}

	private TreeNode helper(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2) {
		if(p1 == p2)
			return new TreeNode(preorder[p1]);
		if(p1 > p2 || i1 > i2)
			return null;

		TreeNode root = new TreeNode(preorder[p1]);
		int r = map.get(root.val);

		//            p1     rs     p2
		//preorder = [3, 9, 20, 15, 7]
		//            i1 r          i2
		// inorder = [9, 3, 15, 20, 7]
		//            0. 1.  2.  3. 4

		int numOfNodesInRightTree = i2 - r;
		int rs = p2 - numOfNodesInRightTree + 1; //start of right tree in preorder array

		root.left = helper(preorder, inorder, p1+1, rs-1, i1, r-1);
		root.right = helper(preorder, inorder, rs, p2, r, i2);

		return root;
	}
	  

	public static void main(String[] args) {
		ConstructBinaryTreefromPreorderandInorder c = new ConstructBinaryTreefromPreorderandInorder();

		//int[] preorder = {1,3,2,4};
		//int[] inorder = {1,2,3,4};
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};

		TreeNode root = c.buildTree(preorder, inorder);
		System.out.println(root);
	}

}
