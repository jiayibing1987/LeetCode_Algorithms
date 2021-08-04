package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberofWeeksCanWork {

    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length;
        int max = -1;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += milestones[i];
            max = Math.max(max, milestones[i]);
            if(milestones[i] > max) {
                max = milestones[i];
            }
        }
        long rest = sum - max;

        if(max <= rest) return sum;
        else return rest * 2 + 1;
    }

    public long numberOfWeeks1(int[] milestones) {
        int n = milestones.length;
        PriorityQueue<long []> pq = new PriorityQueue<>((a, b) -> (int) (b[0] - a[0]));
        long count = 0;

        Arrays.sort(milestones);
        int p1 = 0;
        int p2 = n-1;
        if(n >= 3) {
            while(milestones[p2] != milestones[p2 - 1] && p2 - p1 >= 2) {
                int gap = milestones[p2] - milestones[p2 - 1];
                if(milestones[p1] <= gap) {
                    milestones[p2] -= milestones[p1];
                    count += milestones[p1] * 2;
                    p1 ++;
                } else {
                    milestones[p2] -= gap;
                    milestones[p1] -= gap;
                    count += gap * 2;
                }
            }
        }
        if(p1 == p2)
            return count + 1;
        else if (p2 - p1 == 1) {
            count += 2 * milestones[p1];
            if(milestones[p2] > milestones[p1])
                count ++;
            return count;
        } else {
            for(int i = p1; i < n; i++) {
                count += milestones[i];
            }
            return count;
        }

        for(int i = p1; i < n; i++) {
            pq.add(new long[] {milestones[i], 1});
        }

        while(pq.size() > 1) {
            long[] first = pq.poll();
            while(!pq.isEmpty() && first[0] == pq.peek()[0]) {
                long[] next = pq.poll();
                first[1] += next[1];
            }

            if(pq.isEmpty()) {
                if(first[1] > 1) {
                    count += first[1] * first[0];
                } else {
                    count ++;
                }
                break;
            } else {
                if(first[1] == 1) {

                } else {
                    count += (first[0] - pq.peek()[0]) * first[1];
                    first[0] = pq.peek()[0];
                    //int[] second = new int[]{first[0] - pq.peek()[0],  first[1]};
                    pq.add(first);
                    //pq.add(second);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumNumberofWeeksCanWork m = new MaximumNumberofWeeksCanWork();
        int[] a1 = new int[] {5,2,1};
        //System.out.println(m.numberOfWeeks(a1));

        int[] a2 = new int[] {9,3,6,8,2,1};
        System.out.println(m.numberOfWeeks(a2));
    }
}
