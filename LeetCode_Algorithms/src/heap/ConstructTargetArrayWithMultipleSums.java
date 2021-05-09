package heap;

import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {

    public boolean isPossible(int[] target) {
        int n = target.length;
        if(n == 1) return target[0] == 1;
        int sumQ = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int t : target) {
            sumQ += t;
            pq.add(t);
        }

        while(!pq.isEmpty() && pq.peek() > 1) {
            int largest = pq.poll();
            sumQ -= largest;

            if(sumQ == 1) return true;

            int newNumber;
            if(largest / sumQ >= 2) {
                newNumber = largest % sumQ;
            } else {
                newNumber = largest - sumQ;
            }

            if(newNumber < 1) return false;

            pq.add(newNumber);
            sumQ += newNumber;
        }
        return true;
    }

    public static void main(String[] args) {
        ConstructTargetArrayWithMultipleSums t = new ConstructTargetArrayWithMultipleSums();
        int[] a = {2,900000001};
        System.out.println(t.isPossible(a));
    }

}
