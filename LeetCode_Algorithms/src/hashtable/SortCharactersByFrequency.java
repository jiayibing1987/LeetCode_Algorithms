package hashtable;

import java.util.*;

public class SortCharactersByFrequency {

    //bucket sort
    public String frequencySort(String s) {
        if(s == null) return null;
        String[] bucket = new String[s.length()+1];
        Arrays.fill(bucket, "");

        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            char c = entry.getKey();
            int temp = frequency;
            StringBuilder sb = new StringBuilder(bucket[frequency]);
            while(temp > 0) {
                sb.append(c);
                temp --;
            }
            bucket[frequency] = sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = bucket.length-1; i >= 0; i--) {
            sb.append(bucket[i]);
        }
        return  sb.toString();
    }

    public String frequencySort1(String s) {
        if(s == null) return null;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue(new EntryComparator());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            int frequency = entry.getValue();
            while(frequency > 0) {
                sb.append(entry.getKey());
                frequency--;
            }
        }
        return sb.toString();
    }

    class EntryComparator implements Comparator<Map.Entry<Character, Integer>> {

        @Override
        public int compare(Map.Entry<Character, Integer> t1, Map.Entry<Character, Integer> t2) {
            return t2.getValue() - t1.getValue();
        }
    }

    public static void main(String[] args) {
        String s = new SortCharactersByFrequency().frequencySort("raaeaedere");
        System.out.println(s);
    }
}
