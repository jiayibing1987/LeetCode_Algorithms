package hashtable;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    Map<Integer, Integer> actual_map;
    Map<Integer, Integer> count_map;
    Map<Integer, LinkedHashSet<Integer>> linked_map;
    int cap;
    int min;

    public LFUCache(int capacity) {
        actual_map = new HashMap<>();
        count_map = new HashMap<>();
        linked_map = new HashMap<>();
        linked_map.put(1, new LinkedHashSet<>());
        cap = capacity;
        min = 1;
    }

    public int get(int key) {
        if (actual_map.containsKey(key)) {
            updateLinkedMapIfKeyExists(key);
            //update count map and return value from actual map
            count_map.put(key, count_map.get(key) + 1);
            return actual_map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cap == 0) return;
        if (actual_map.containsKey(key)) {
            updateLinkedMapIfKeyExists(key);
        } else {
            //when a new key get in and if current count of key reaches cap, need to remove the LFU key
            if (actual_map.size() == cap) {
                int LFU_key = linked_map.get(min).iterator().next();
                linked_map.get(min).remove(LFU_key);
                count_map.remove(LFU_key);
                actual_map.remove(LFU_key);
            }
            //add new key into linked map and set min to 1
            linked_map.get(1).add(key);
            min = 1;
        }
        count_map.put(key, count_map.getOrDefault(key, 0) + 1);
        actual_map.put(key, value);
    }

    /*update linked map*/
    private void updateLinkedMapIfKeyExists(int key) {
        int pre_count = count_map.get(key);
        int cur_count = pre_count + 1;
        linked_map.get(pre_count).remove(key); //remove from previous count hash set
        //add key into new count hash set
        if (!linked_map.containsKey(cur_count)) {
            linked_map.put(cur_count, new LinkedHashSet<>());
        }
        linked_map.get(cur_count).add(key);
        if (pre_count == min && linked_map.get(min).isEmpty())
            min++;
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(10);
        lfu.put(10, 13);
        lfu.put(3, 17);
        lfu.put(6, 11);
        lfu.put(10, 5);
        lfu.put(9, 10);
        lfu.get(13);
        lfu.put(2, 19);
        lfu.get(2);
        lfu.get(3);
        lfu.put(5, 25);
        lfu.get(8);
        lfu.put(9, 22);
        lfu.put(5, 5);
        lfu.put(1, 30);
        lfu.get(11);
        lfu.put(9, 12);
        lfu.get(7);
        lfu.get(5);
        lfu.get(8);
        lfu.get(9);
        lfu.put(4, 30);
        lfu.put(9, 3);
        lfu.get(9);
        lfu.get(10);
        lfu.get(10);
        lfu.put(6, 14);
        lfu.put(3, 1);
        lfu.get(3);
        lfu.put(10, 11);
        lfu.get(8);
        lfu.put(2, 14);
        lfu.get(1);
        lfu.get(5);
        lfu.get(4);
        lfu.put(11, 4);
        lfu.put(12, 24);
        lfu.put(5, 18);
        lfu.get(13);
        lfu.put(7, 23);
        lfu.get(8);
        lfu.get(12);
        lfu.put(3, 27);
        lfu.put(2, 12);
        lfu.get(5);
        lfu.put(2, 9);
        lfu.put(13, 4);
        lfu.put(8, 18);
        lfu.put(1, 7);
        lfu.get(6);
        lfu.put(9, 29);
        lfu.put(8, 21);
        lfu.get(5);
        lfu.put(6, 30);
        lfu.put(1, 12);
        lfu.get(10);
        lfu.put(4, 15);
        lfu.put(7, 22);
        lfu.put(11, 26);
        lfu.put(8, 17);
        lfu.put(9, 29);
        lfu.get(5);
        lfu.put(3, 4);
        lfu.put(11, 30);
        lfu.get(12);
        lfu.put(4, 29);
        lfu.get(3);
        lfu.get(9);
        lfu.get(6);
        lfu.put(3, 4);
        lfu.get(1);
        lfu.get(10);
        lfu.put(3, 29);
        lfu.put(10, 28);
        lfu.put(1, 20);
        lfu.put(11, 13);
        lfu.get(3);
        lfu.put(3, 12);
        lfu.put(3, 8);
        lfu.put(10, 9);
        lfu.put(3, 26);
        lfu.get(8);
        lfu.get(7);
        lfu.get(5);
        lfu.put(13, 17);
        lfu.put(2, 27);
        lfu.put(11, 15);
        lfu.get(12);
        lfu.put(9, 19);
        lfu.put(2, 15);
        lfu.put(3, 16);
        lfu.get(1);
        lfu.put(12, 17);
        lfu.put(9, 1);
        lfu.put(6, 19);
        lfu.get(4);
        lfu.get(5);
        lfu.get(5);
        lfu.put(8, 1);
        lfu.put(11, 7);
        lfu.put(5, 2);
        lfu.put(9, 28);
        lfu.get(1);
        lfu.put(2, 2);
        lfu.put(7, 4);
        lfu.put(4, 22);
        lfu.put(7, 24);
        lfu.put(9, 26);
        lfu.put(13, 28);
        lfu.put(11, 26);
    }

}
