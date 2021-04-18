package contest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int cost : costs)
            pq.add(cost);

        while(!pq.isEmpty() && pq.peek() <= coins) {
            coins -= pq.poll();
        }

        return costs.length - pq.size();
    }

    public static void main (String[] args) {
        MaximumIceCreamBars m = new MaximumIceCreamBars();
        int[] a = {1,3,2,4,1};
        //System.out.println(m.maxIceCream(a, 7));
        int[] b = {1,6,3,1,2,5};
        System.out.println(m.maxIceCream(b, 20));
    }
}
