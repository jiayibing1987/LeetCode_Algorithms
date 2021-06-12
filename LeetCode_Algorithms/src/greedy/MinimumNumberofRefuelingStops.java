package greedy;

import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        if(n == 0) return startFuel >= target ? 0 : -1;
        int position = startFuel;
        int count = 0;
        //a PriorityQueue to store all reachable stations
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(int i = 0; i <= n; i++) {
            int[] station = i == n ? new int[] {target, 0} : stations[i];
            //when find a station can not reach, get previous station with largest amount of gas and refill
            while(!pq.isEmpty() && position < station[0]) {
                position += pq.poll()[1];
                count ++;
            }
            //only add reachable station
            if(position >= station[0]) {
                pq.add(station);
            }
        }

        if(position < target)
            return -1;
        return count;
    }

    public static void main(String[] args) {
        MinimumNumberofRefuelingStops m = new MinimumNumberofRefuelingStops();
        int[][] a = new int[][] {{10,60},{20,30},{30,30},{60,40}};
        //System.out.println(m.minRefuelStops(100, 10, a));

        int[][] b = new int[][] {{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}};
        System.out.println(m.minRefuelStops(1000, 299, b));
    }
}
