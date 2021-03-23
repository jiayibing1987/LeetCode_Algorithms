package greedy;

import java.util.*;

public class MeetingRoomsTwo {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            if(pq.peek() <= intervals[i][0])
                pq.poll();

            pq.add(intervals[i][1]);
        }
        return pq.size();
    }


    public static void main(String[] args) {
        int[][] a = {{1, 2}, {1, 2}, {3, 4}, {3, 4}};
        System.out.println(new MeetingRoomsTwo().minMeetingRooms(a));
    }
}
