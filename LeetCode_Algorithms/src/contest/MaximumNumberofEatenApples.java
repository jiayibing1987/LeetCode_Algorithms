package contest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberofEatenApples {

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int count = 0;

        int i = 0;
        while (!pq.isEmpty() || i < n) {
            if (i < n && apples[i] > 0)
                pq.add(new int[]{i + days[i]-1, apples[i]});

            while (!pq.isEmpty() && pq.peek()[0] < i)
                pq.poll();

            if (!pq.isEmpty()) {
                int[] batch = pq.peek();
                if (batch[0] >= i && batch[1] > 0) {
                    count++;
                    batch[1]--;
                    if (batch[1] == 0)
                        pq.poll();
                }
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumNumberofEatenApples m = new MaximumNumberofEatenApples();
        int[] a1 = new int[]{1, 2, 3, 5, 2};
        int[] d1 = new int[]{3, 2, 1, 4, 2};

        int[] a2 = new int[]{3, 0, 0, 0, 0, 2};
        int[] d2 = new int[]{3, 0, 0, 0, 0, 2};

        int[] a3 = new int[]{1};
        int[] d3 = new int[]{2};

        int[] a4 = new int[]{9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5};
        int[] d4 = new int[]{3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7};
        System.out.println(m.eatenApples(a1, d1));
        System.out.println(m.eatenApples(a2, d2));
        System.out.println(m.eatenApples(a3, d3));
        System.out.println(m.eatenApples(a4, d4));
    }
}
