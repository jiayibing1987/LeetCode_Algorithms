package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CarPooling {

    //O(n)
    public boolean carPooling(int[][] trips, int capacity) {
        int[] c = new int[1000];
        for(int[] trip : trips) {
            c[trip[1]] += trip[0];
            c[trip[2]] -= trip[0];
        }

        int count = 0;
        for(int cap : c) {
            count += cap;
            if(count > capacity) return false;
        }
        return true;
    }

    //O(nlogn)
    public boolean carPooling2(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] trip : trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > capacity) return false;
        }
        return true;
    }


    //O(n2)
    public boolean carPooling1(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);

            int[] c = new int[1000];
        for(int[] trip : trips) {
            for(int i=trip[1]; i<trip[2]; i++) {
                c[i] += trip[0];
                if(c[i] > capacity)
                    return false;
            }
        }
        return true;
    }

}
