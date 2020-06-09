package dynamicprogramming;

import java.util.Map;
import java.util.TreeMap;

/**
 * 983. Minimum Cost For Tickets
 */
public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for(int day : days)
            map.put(day, 0);
        int[] dayPass = new int[] {1, 7, 30};

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int min = Integer.MAX_VALUE;
            int day = entry.getKey();
            int cost = entry.getValue();
            if(day == 0) continue;
            for(int i=0; i<costs.length; i++) {
                int floorKey = day-dayPass[i] <0 ? 0 : map.floorKey(day-dayPass[i]);
                min = Math.min(min, map.get(floorKey) + costs[i]);
            }
            map.put(day, min);
        }
        return map.get(days[days.length-1]);
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {7,2,15};
        System.out.println(new MinimumCostForTickets().mincostTickets(days, costs));
    }
}
