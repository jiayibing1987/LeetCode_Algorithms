package thirtydayschallenge;

import java.util.*;

public class LRUCache {
    /**
     * can also use a double linked list and a hash map to track key and node value
     */
    int capacity;
    Map<Integer, Integer> map;
    Set<Integer> set;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Integer>();
        set = new LinkedHashSet<Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(set.contains(key)) {
            set.remove(key);
            set.add(key);
        }
       return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if(set.size() < capacity){
            map.put(key, value);
            if(set.contains(key))
                set.remove(key);
            set.add(key);
        }else{
            int toRemove = set.contains(key) ? key : set.iterator().next();
            set.remove(toRemove);
            set.add(key);
            map.remove(toRemove);
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<Integer>();
        LRUCache l = new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
         res.add(l.get(1));
        l.put(3,3);
        res.add(l.get(2));
        System.out.println(res);
    }
}
