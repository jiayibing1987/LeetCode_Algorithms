package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * @author Ryan
 *
 */
public class RandomizedSet {

	List<Integer> list;
	Map<Integer, Integer> map;
	int firstIndex;
	int lastIndex;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
		firstIndex = 0;
		lastIndex = -1;
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (!map.containsKey(val)) {
			list.add(val);
			lastIndex++;
			map.put(val, lastIndex);
			return true;
		}
		return false;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (map.containsKey(val)) {
			int index = map.remove(val);
			if (index != firstIndex) {
				int firstElement = list.get(firstIndex);
				list.set(index, firstElement);
				map.put(firstElement, index);
			}
			firstIndex++;
			return true;
		}
		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random r = new Random();
		int randomIndex = r.nextInt(lastIndex - firstIndex + 1) + firstIndex;
		return list.get(randomIndex);
	}

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		boolean param_1 = obj.insert(0);
		obj.remove(0);
		boolean param_4 = obj.insert(1);
		boolean param_2 = obj.remove(2);
		int param_3 = obj.getRandom();
	}

}
