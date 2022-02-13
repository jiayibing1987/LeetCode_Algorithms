package contest;

import java.util.PriorityQueue;

public class RemovingMinimumNumberofMagicBeans {

    public long minimumRemoval(int[] beans) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for(int bean : beans) {
            pq.add(bean);
            sum += bean;
        }

        long min = sum;
        long processed = 0;
        while(!pq.isEmpty()) {
            long cur = pq.poll();
            long remain = sum - cur - processed;

            long op = processed + (remain - (cur * pq.size()));
            min = Math.min(op, min);
        }
        return min;
    }

    public static void main(String[] args) {
        RemovingMinimumNumberofMagicBeans re = new RemovingMinimumNumberofMagicBeans();
        int[] beans1 = new int[] {4,1,6,5};
        System.out.println(re.minimumRemoval(beans1));
        int[] beans2 = new int[] {2,10,3,2};
        System.out.println(re.minimumRemoval(beans2));

    }
}
