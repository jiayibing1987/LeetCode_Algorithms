package hashtable;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

    Map<String , TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        TreeMap<Integer, String> treeMap = map.get(key);
        treeMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        } else {
            TreeMap<Integer, String> treeMap = map.get(key);
            Map.Entry<Integer, String> e = treeMap.floorEntry(timestamp);
            return e == null ? "" : e.getValue();
        }
    }
}
