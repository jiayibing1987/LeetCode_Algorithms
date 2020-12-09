package thirtydayschallenge;

import tree.FindBottomLeftTreeValue;
import util.TreeNode;

public class PopulatingNextRightPointersTwo {

    public Node connect(Node root) {
        if(root == null) return null;
        Node head = root;
        while(head != null) {
            Node nextLevelHead = null;
            Node preNode = null;
            while(head != null) {
                Node left = head.left;
                Node right = head.right;
                if(left != null && right != null) {
                    if(preNode != null) preNode.next = left;
                    left.next = right;
                    preNode = right;
                    if(nextLevelHead == null) nextLevelHead = left;
                } else if(left != null) {
                    if(preNode != null) preNode.next = left;
                    preNode = left;
                    if(nextLevelHead == null) nextLevelHead = left;
                } else if (right != null) {
                    if(preNode != null) preNode.next = right;
                    preNode = right;
                    if(nextLevelHead == null) nextLevelHead = right;
                } else {
                    //both are null, do nothing.
                }
                head = head.next;
            }
            head = nextLevelHead;
        }
        return root;
    }

    public static void main(String[] args) {
        //10,5,15,null,null,6,20
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node3.right = node5;

        PopulatingNextRightPointersTwo p = new PopulatingNextRightPointersTwo();
        System.out.println(p.connect(node1));
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
