package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class WiggleSortTwo {

    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int n : nums)
            pq.add(n);

        for(int i=1; i<nums.length; i=i+2) {
            nums[i] = pq.poll();
        }

        for(int i=0; i<nums.length; i=i+2) {
            nums[i] = pq.poll();
        }

    }

    public static void main(String[] args) {
        WiggleSortTwo w = new WiggleSortTwo();
        int[] a = {1, 5, 1, 1, 6, 4};
        w.wiggleSort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {1, 3, 2, 2, 3, 1};
        w.wiggleSort(b);
        System.out.println(Arrays.toString(b));

        int[] c = {4, 5, 5, 6};
        w.wiggleSort(c);
        System.out.println(Arrays.toString(c));

    }

}
