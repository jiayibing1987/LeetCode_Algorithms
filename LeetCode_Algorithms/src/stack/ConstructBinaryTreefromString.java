package stack;

import util.TreeNode;

import java.util.Stack;

public class ConstructBinaryTreefromString {

    public TreeNode str2tree(String s) {
        if(s == null || s.isEmpty()) return null;
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c) || c == '-') {
                sb.append(c);
            } else if (c == '(') {
                if(sb.length() > 0) {
                    stack.push(new TreeNode(Integer.valueOf(sb.toString())));
                    sb.setLength(0);
                }
            } else if (c == ')') {
                if(sb.length() > 0) {
                    stack.push(new TreeNode(Integer.valueOf(sb.toString())));
                    sb.setLength(0);
                }
                TreeNode curNode = stack.pop();
                TreeNode subRoot = stack.peek();
                if(subRoot.left == null) {
                    subRoot.left = curNode;
                } else {
                    subRoot.right = curNode;
                }
            }
        }
        if(sb.length() > 0 && stack.isEmpty()) stack.push(new TreeNode(Integer.valueOf(sb.toString())));
        return stack.peek();
    }

}
