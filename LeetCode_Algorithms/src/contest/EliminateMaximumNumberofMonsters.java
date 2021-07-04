package contest;

import java.util.PriorityQueue;

public class EliminateMaximumNumberofMonsters {

    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = dist.length;
        for(int i = 0; i < n; i++) {
            int x;
            if(dist[i] % speed[i] == 0) {
                x = dist[i] / speed[i];
            } else {
                x = dist[i] / speed[i] + 1;
            }
            pq.add(x);
        }

        int time = 0;
        while(!pq.isEmpty()) {
            if(pq.peek() <= time ) {
                break;
            }
            pq.poll();
            time ++;
        }
        return n - pq.size();
    }

    public static void main(String[] args) {
        EliminateMaximumNumberofMonsters e = new EliminateMaximumNumberofMonsters();
        System.out.println(e.eliminateMaximum(new int[] {1,3,4}, new int[] {1,1,1}));
        System.out.println(e.eliminateMaximum(new int[] {3,2,4}, new int[] {5,3,2}));
    }
}
