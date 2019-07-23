package tree;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * @author Ryan
 *
 */
public class ConstructBinaryTreefromInorderandPostorder {

	int postIndex;
	Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(postorder.length == 0) return null;
        postIndex = postorder.length-1;
		map = new HashMap<Integer, Integer>();
		for(int i=0; i<inorder.length; i++)
			map.put(inorder[i], i);
        return build(inorder, postorder, 0, postorder.length-1);
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int low, int high){
    	if(low > high) return null;
    	TreeNode node = new TreeNode(postorder[postIndex]);
    	postIndex--;
    	int rootIndex = map.get(node.val);
    	node.right = build(inorder, postorder, rootIndex+1, high);
    	node.left = build(inorder, postorder, low, rootIndex-1);
    	return node;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
