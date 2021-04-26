package heap;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> laddersHeap = new PriorityQueue<>();
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int diff = heights[i] - heights[i - 1];
            if(diff < 0) continue;
            if(laddersHeap.size() < ladders) {
                laddersHeap.add(diff);
            } else {
                if(!laddersHeap.isEmpty() && diff > laddersHeap.peek()) {
                    int minFromLadder = laddersHeap.poll();
                    laddersHeap.add(diff);
                    sum += minFromLadder;
                } else {
                    sum += diff;
                }

                if(sum > bricks) return i-1;
            }
        }
        return n-1;
    }

}
