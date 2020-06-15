package graph;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 */
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //init map
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] flight : flights) {
            if(!map.containsKey(flight[0]))
                map.put(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        visited.add(src);
        int stop = 0;
        int res = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] node = queue.poll();
                if(node[0] == dst)
                    res = Math.min(res, node[1]);

                List<int[]> children = map.get(node[0]);
                if(children == null) continue;

                for(int[] child : children) {
                    if(child[1] + node[1] > res) continue;
                    queue.add(new int[] {child[0], child[1] + node[1]});
                }
            }
            if(stop > K)
                break;
            stop++;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] f = new int[][] {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(5, f,0, 2, 2));

    }
}
