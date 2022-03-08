package stack;

import java.util.Set;
import java.util.Stack;

abstract class Node {
    public abstract int evaluate();
}

class TreeNode extends Node {
    public int evaluate() {
        return value;
    }
    public String s;
    public Integer value;
    public Node left;
    public Node right;

    public TreeNode (String s) {
        this.s = s;
    }

    public TreeNode (String s, int v) {
        this.s = s;
        this.value = v;
    }

    public String toString() {
        return s + " " + value;
    }
}

public class TreeBuilder {

    Node buildTree(String[] postfix) {
        Stack<TreeNode> stack = new Stack<>();
        Set<String> operators = Set.of("+", "-", "*", "/");
        int n = postfix.length;
        for(int i = n - 1; i >= 0; i --) {
            if(operators.contains(postfix[i])) {
                TreeNode node = new TreeNode(postfix[i]);
                stack.push(node);
            } else {
                TreeNode left = new TreeNode(postfix[i], Integer.parseInt(postfix[i]));
                TreeNode root;
                while(!stack.isEmpty() && stack.peek().value != null) {
                    TreeNode right = stack.pop();
                    root = stack.pop();
                    root.left = left;
                    root.right = right;
                    root.value = calc(left.value, right.value, root.s);
                    left = root;
                }

                stack.push(left);
            }
        }
        return stack.peek();
    }

    private int calc(int a, int b, String op) {
        int res;
        switch (op) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            default:
                res = a / b;
                break;
        }
        return res;
    }

    public static void main(String[] args) {
          TreeBuilder obj = new TreeBuilder();

          String[] s1 = new String[] {"3","4","+","2","*","7","/"};
          Node expTree = obj.buildTree(s1);
          System.out.println(expTree.evaluate());
    }
}
