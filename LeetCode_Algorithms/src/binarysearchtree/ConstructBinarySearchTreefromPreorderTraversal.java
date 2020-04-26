package binarysearchtree;

import util.TreeNode;

import java.util.Stack;

/**
 * #1008. Construct Binary Search Tree from Preorder Traversal
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 */
public class ConstructBinarySearchTreefromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for(int i=1; i<preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if(preorder[i] < stack.peek().val){
                stack.peek().left = node;
            }else {
                TreeNode parentNode = null;
                while(!stack.isEmpty() && stack.peek().val < preorder[i]){
                    parentNode = stack.pop();
                }
                parentNode.right = node;
            }
            stack.push(node);
        }
        return root;
    }

}
