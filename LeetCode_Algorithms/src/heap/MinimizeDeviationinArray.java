package heap;

import java.util.*;

public class MinimizeDeviationinArray {

    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        int max = 0;
        for(int num : nums) {
            int minPossibleNum = num;
            int maxPossibleNum = num;
            while(minPossibleNum % 2 == 0) {
                minPossibleNum = minPossibleNum / 2;
            }
            if(num % 2 == 1) maxPossibleNum = num * 2;
            max = Math.max(max, minPossibleNum);
            pq.add(new int[] {minPossibleNum, maxPossibleNum});
        }

        int minDev = max - pq.peek()[0];
        while(pq.peek()[0] < pq.peek()[1]) {
            int min = pq.peek()[0];
            int original = pq.peek()[1];

            pq.poll();
            pq.add(new int[] {min * 2, original});
            max = Math.max(min * 2, max);
            int curDev = max - pq.peek()[0];

            minDev = Math.min(curDev, minDev);
        }
        return minDev;
    }

    public static void main(String[] args) {
        MinimizeDeviationinArray m = new MinimizeDeviationinArray();
        int[] a = {1,2,3,4};
        int[] b = {4,1,5,20,3};
        int[] c = {2,10,8};
        int[] d = {4,4,9,5};
        int[] e = {3, 5};
        int[] f = {165,319,305};
        System.out.println(m.minimumDeviation(a));
        System.out.println(m.minimumDeviation(b));
        System.out.println(m.minimumDeviation(c));
        System.out.println(m.minimumDeviation(d));
        System.out.println(m.minimumDeviation(e));
        System.out.println(m.minimumDeviation(f));

    }
}
