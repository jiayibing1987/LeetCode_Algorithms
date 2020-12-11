package hashtable;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    Map<Integer, Pair<String, Integer>> customerMap;
    Map<String, Pair<Long, Integer>> stationMap;
    public UndergroundSystem() {
        customerMap = new HashMap<>();
        stationMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        customerMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> stationWithTime = customerMap.get(id);
        customerMap.remove(id);
        long time = t - stationWithTime.getValue();
        String stationCombo = stationWithTime.getKey() + " " + stationName;
        if(!stationMap.containsKey(stationCombo)) {
            stationMap.put(stationCombo, new Pair<>(time, 1));
        } else {
            Pair<Long, Integer> sumAndCount = stationMap.get(stationCombo);
            stationMap.put(stationCombo, new Pair<>(time + sumAndCount.getKey(), sumAndCount.getValue() + 1));
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<Long, Integer> sumAndCount = stationMap.get(startStation + " " + endStation);
        return (double)sumAndCount.getKey() / (double)sumAndCount.getValue();
    }

    public class Pair<K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
