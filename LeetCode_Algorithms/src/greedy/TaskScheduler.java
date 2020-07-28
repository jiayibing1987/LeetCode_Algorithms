package greedy;

import java.util.*;

/**
 * 621. Task Scheduler
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int target = n + 1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) ->
                a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());
        pq.addAll(map.entrySet());

        int res = 0;
        int count = target;
        while(!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> temp = new ArrayList<>();
            int size = pq.size();
            int num_iteration = Math.min(size, target);
            for(int i=0; i<num_iteration; i++) {
                Map.Entry<Character, Integer> e = pq.poll();
                e.setValue(e.getValue()-1);
                if(e.getValue() > 0) temp.add(e);
                count --;
                res++;
            }

            pq.addAll(temp);
            if(!temp.isEmpty()) res += count;

            count = target;
            temp.clear();
        }
        return res;
    }

    public static void main (String[] args) {
        TaskScheduler t = new TaskScheduler();
        char[] a = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(t.leastInterval(a, 2));
    }
}
