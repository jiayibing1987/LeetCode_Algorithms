package linkedlist;

import util.ListNode;

public class SwappingNodeinaLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        ListNode node1 = null;
        ListNode node1Pre = null;

        int index = -1;
        while (cur != null) {
            if (index == k - 2) {
                node1Pre = cur;
                node1 = cur.next;
            }
            cur = cur.next;
            index++;
        }

        int size = index;
        int targetIndex2 = size - k;

        cur = dummy;
        index = -1;
        ListNode node2Pre = null;
        ListNode node2 = null;
        while (cur != null) {
            if (index == targetIndex2 - 1) {
                node2Pre = cur;
                node2 = cur.next;
            }
            cur = cur.next;
            index++;
        }

        //swap
        if(node1.next == node2) {
            ListNode node2Next = node2.next;
            node1Pre.next = node2;
            node1.next = node2Next;
            node2.next = node1;
        } else if (node2.next == node1) {
            ListNode node1Next = node1.next;
            node2Pre.next = node1;
            node2.next = node1Next;
            node1.next = node2;
        } else if (node1 != node2) {
            ListNode node1Next = node1.next;
            ListNode node2Next = node2.next;

            node1Pre.next = node2;
            node2.next = node1Next;

            node2Pre.next = node1;
            node1.next = node2Next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SwappingNodeinaLinkedList s = new SwappingNodeinaLinkedList();
        ListNode n1 = new util.ListNode(1);
        ListNode n2 = new util.ListNode(2);
        ListNode n3 = new util.ListNode(3);
        ListNode n4 = new util.ListNode(4);
        ListNode n5 = new util.ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(s.swapNodes(n1, 2));
    }


}
