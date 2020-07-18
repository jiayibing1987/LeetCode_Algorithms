package heap;

import java.util.*;

public class TopKFrequentElements {

    //priority queue
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int key : map.keySet())
            pq.add(key);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if(!pq.isEmpty())
                res[i] = pq.poll();
        }
        return res;
    }

    //bucket sort
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(bucket[entry.getValue()] == null) {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                bucket[entry.getValue()] = list;
            }else{
                bucket[entry.getValue()].add(entry.getKey());
            }
        }

        int[] res = new int[k];
        int count = 0;
        for(int i=bucket.length-1; i>=0; i--){
            if(bucket[i] != null) {
                for(int n : bucket[i]) {
                    res[count++] = n;
                    if(count == k) return res;
                }
            }
        }
        return res;
    }
}
