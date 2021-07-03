package binarysearch;

import java.util.LinkedList;

public class HitCounter {

    LinkedList<Pair<Integer, Integer>> q;
    public HitCounter() {
        q = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!q.isEmpty() && q.getLast().getKey() == timestamp)
            q.getLast().value++;
        q.add(new Pair<>(timestamp, 1));
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && q.peek().getKey() <= timestamp - 300) {
            q.poll();
        }
        int sum = 0;
        for(Pair<Integer, Integer> p : q) {
            sum += p.getValue();
        }
        return sum;
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
