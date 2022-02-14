package hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * #146 LRU cache
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and put.
 * 
 * @author Ryan
 *
 */
public class LRUCache {
	/*
	 * solution 2
	 * use a double linked list, a list node contain key and value and pre next reference
	 * a double linked list and remove it self without using any other node's reference.
	 * and also create a hash map to store key -> node, to make sure can find the node in O(1) time
	 * logic is similar as solution 1, always add most recent node to the end of list, 
	 * and keep least recent node in head
	 * 
	 *  */
	int cap;
	int size;
	Map<Integer, ListNode> map;
	ListNode dummyHead;
	ListNode tail;

	public LRUCache(int capacity) {
		this.cap = capacity;
		size = 0;
		map = new HashMap<>();
		dummyHead = new ListNode(-1, -1);
		tail = new ListNode(-2, -2);
		dummyHead.next = tail;
		tail.pre = dummyHead;
	}

	public int get(int key) {
		if(!map.containsKey(key))
			return -1;

		int value = map.get(key).v;
		removeNode(key, map.get(key));
		addToTail(key, value);
		return value;
	}

	public void put(int key, int value) {
		if(!map.containsKey(key)) {
			addToTail(key, value);
			size ++;
			if(size > cap) {
				removeNode(dummyHead.next.k, dummyHead.next);
				size = cap;
			}
		} else {
			removeNode(key, map.get(key));
			addToTail(key, value);
		}
	}

	private void removeNode(int key, ListNode node) {
		ListNode nextNode = node.next;
		ListNode preNode = node.pre;
		preNode.next = nextNode;
		nextNode.pre = preNode;
		map.remove(key);
	}

	private void addToTail (int key, int value) {
		ListNode newNode = new ListNode(key, value);
		ListNode nodeBeforeTail = tail.pre;

		nodeBeforeTail.next = newNode;
		newNode.pre = nodeBeforeTail;

		newNode.next = tail;
		tail.pre = newNode;
		map.put(key, newNode);
	}

	public class ListNode {
		int k;
		int v;
		ListNode pre;
		ListNode next;

		public ListNode() {}

		public ListNode (int k, int v) {
			this.k = k;
			this.v = v;
		}
	}

	public static void main(String[] args) {
		LRUCache c = new LRUCache(2);
		c.put(1, 1);
		c.put(2, 2);
		System.out.println(c.get(1));
		c.put(3, 3);
		System.out.println(2);
		c.put(4, 4);
		
		System.out.println(c.get(1));
		System.out.println(c.get(3));
		System.out.println(c.get(4));
	}

}
