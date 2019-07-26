package tree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class FlattenBinaryTreetoLinkedList {

	
	TreeNode pre;
	//a post order traversal from right to left
	public void flatten(TreeNode root){
		if(root == null) return;
		flatten(root.right);
		flatten(root.left);
		root.right = pre;
		root.left = null;
		pre = root;
	}
	
    public void flatten1(TreeNode root) {
    	if(root == null) return;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	dfs(q, root);
    	TreeNode pre = q.poll();
    	while(!q.isEmpty()){
    		pre.left = null;
    		TreeNode current = q.poll();
    		pre.right = current;
    		pre = current;
    	}
    }
    
    public void dfs(Queue<TreeNode> q, TreeNode node){
    	if(node == null) return;
    	q.add(node);
    	dfs(q, node.left);
    	dfs(q, node.right);
    }
    
	public static void main(String[] args) {
		FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
		TreeNode root = new TreeNode(0);
		f.flatten(root);
	}

}
