package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 1029. Two City Scheduling
 */
public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i =0; i< costs.length; i++) {
            int diff = costs[i][0] - costs[i][1];
            if(map.containsKey(diff))
                map.get(diff).add(i);
            else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(diff, l);
            }
        }

        int half = costs.length / 2;
        int count = 0;
        int res = 0;
        for(List<Integer> values : map.values()) {
            for(int index : values) {
                if(count < half) {
                    res += costs[index][0];
                }else {
                    res += costs[index][1];
                }
                count ++;
            }
        }
        return res;
    }

}
