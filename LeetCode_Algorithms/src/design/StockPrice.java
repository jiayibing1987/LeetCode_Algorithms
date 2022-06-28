package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class StockPrice {

    Map<Integer, Integer> time_map;
    TreeMap<Integer, Integer> price_map;
    int min;
    int max;
    int lastTime;
    public StockPrice() {
        price_map = new TreeMap<>();
        time_map = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        lastTime = 0;
    }

    public void update(int timestamp, int price) {
        if(timestamp >= lastTime) {
            lastTime = timestamp;
        }

        if(time_map.containsKey(timestamp)) {
            int oldPrice = time_map.get(timestamp);
            price_map.put(oldPrice, price_map.getOrDefault(oldPrice, 0) - 1);
            if(price_map.get(oldPrice) == 0)
                price_map.remove(oldPrice);
            price_map.put(price, price_map.getOrDefault(price, 0) + 1);
        }

        time_map.put(timestamp, price);
    }

    public int current() {
        return time_map.get(lastTime);
    }

    public int maximum() {
        return price_map.lastKey();
    }

    public int minimum() {
        return price_map.firstKey();
    }
}

