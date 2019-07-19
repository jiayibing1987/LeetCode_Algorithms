package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreePostorder {

    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null) return list;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curr = null;
		s.push(root);
		
		while(!s.isEmpty()){
			curr = s.pop();
			list.add(0, curr.val);
			
			if(curr.left != null) s.add(curr.left);
			if(curr.right != null) s.add(curr.right);
		}
		return list;
    }
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		node1.left = node2;
		node2.right = node3;

		BinaryTreePostorder postorder = new BinaryTreePostorder();
		System.out.println(postorder.postorderTraversal(node1));
	}

}
