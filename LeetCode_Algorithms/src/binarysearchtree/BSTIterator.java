package binarysearchtree;

import util.TreeNode;
import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> s;
    int pre;
    int count = 0;
    public BSTIterator(TreeNode root) {
        pre = -1;
        s = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            s.push(cur);
            cur = cur.left;
        }
    }

    public int next() {
        TreeNode top = s.pop();
        TreeNode cur = top;
        if(cur.right != null) {
            cur = cur.right;
            while(cur != null){
                s.push(cur);
                cur = cur.left;
            }
        }
        return top.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(20);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        BSTIterator b = new BSTIterator(node1);
        System.out.println(b.next());
        System.out.println(b.next());
        System.out.println(b.hasNext());
        System.out.println(b.next());
        System.out.println(b.hasNext());
        System.out.println(b.next());
        System.out.println(b.hasNext());
        System.out.println(b.next());
        System.out.println(b.hasNext());
    }
}
