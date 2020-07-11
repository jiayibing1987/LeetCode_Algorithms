package linkedlist;

import java.util.Stack;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 */
public class FlattenaMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        Node cur = head;
        Stack<Node> stack = new Stack<>();

        while(cur != null) {
            if(cur.child != null) {
                if(cur.next != null) stack.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }else if(cur.next == null && !stack.isEmpty()){
                Node next = stack.pop();
                cur.next = next;
                next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
