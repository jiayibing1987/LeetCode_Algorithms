package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeRightSideView {

	//bfs
    public List<Integer> rightSideView1(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(root == null) return res;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()){
    		int size = q.size();
    		for(int i=0; i<size; i++){
    			if(i==0) res.add(q.peek().val);
    			TreeNode node = q.poll();
        		if(node.right != null)
        			q.add(node.right);
        		if(node.left != null)
        			q.add(node.left);
    		}
    	}
    	return res;
    }
    
    //dfs
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	List<Integer> res = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Stack<Integer> depthStack = new Stack<Integer>();
    	stack.push(root);
    	depthStack.push(0);
    	while(!stack.isEmpty()){
    		TreeNode node = stack.pop();
    		int currentDepth = depthStack.pop();
    		if(node == null) continue;
    		if(!map.containsKey(currentDepth)){
    			res.add(node.val);
    			map.put(currentDepth, node.val);
    		}
    		stack.push(node.left);
    		stack.push(node.right);
    		depthStack.push(currentDepth+1);
    		depthStack.push(currentDepth+1);
    	}
    	return res;
    }
    

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
