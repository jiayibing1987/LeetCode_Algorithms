package hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * #146 LRU cache
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and put.
 * 
 * @author Ryan
 *
 */
public class LRUCache {
	/*solution1 use linked hashmap*/
	int capacity;
	HashMap<Integer, Integer> map;

	public LRUCache(int capacity) {
		map = new LinkedHashMap<Integer, Integer>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			int value = map.get(key);
			map.remove(key);
			map.put(key, value);
			return value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if(map.containsKey(key)){
			map.remove(key);
		}else{
			if(map.size() == capacity){
				map.remove(map.keySet().iterator().next());
			}
		}
		map.put(key, value);
	}
	
	/*
	 * solution 2
	 * use a double linked list, a list node contain key and value and pre next reference
	 * a double linked list and remove it self without using any other node's reference.
	 * and also create a hash map to store key -> node, to make sure can find the node in O(1) time
	 * logic is similar as solution 1, always add most recent node to the end of list, 
	 * and keep least recent node in head
	 * 
	 *  */

	public static void main(String[] args) {
		LRUCache c = new LRUCache(2);
		c.put(2, 6);
		c.put(1, 5);
		c.put(1, 2);
	//	c.put(4, 1);
		
		System.out.println(c.get(1));
		System.out.println(c.get(2));
	}

}
