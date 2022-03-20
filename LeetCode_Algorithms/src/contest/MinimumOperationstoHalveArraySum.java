package contest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumOperationstoHalveArraySum {

    public int halveArray(int[] nums) {
        int steps = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((x, y) -> Double.compare(y, x));
        double sum = 0;
        for(int num : nums) {
            sum += num;
            pq.add((double) num);
        }

        double target = sum / 2.0d;
        double totalReduced = 0;
        while(totalReduced < target) {
            double largest = pq.poll();
            double half = largest / 2;

            totalReduced += half;
            pq.add(half);
            steps ++;
        }
        return steps;
    }

    public static void main(String[] args) {
        MinimumOperationstoHalveArraySum m = new MinimumOperationstoHalveArraySum();
        System.out.println(m.halveArray(new int[] {5,19,8,1}));
        System.out.println(m.halveArray(new int[] {3,8,20}));
    }
}
