package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public double[] medianSlidingWindow(int[] nums, int k) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        int n = nums.length;
        double[] medians = new double[n-k+1];

        for(int i=0; i<k; i++) {
            this.add(nums[i]);
        }
        medians[0] = findMedian();

        for(int i=0; i<n-k; i++) {
            int j = i + k;
            this.add(nums[j]);
            this.remove(nums[i]);
            medians[i+1] = findMedian();
        }
        return medians;
    }

    private void add(int num) {
        double median = findMedian();
        if(num < median) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();
    }

    private void remove(int num) {
        double median = findMedian();
        if(num < median) {
            maxHeap.remove(num);
        } else if (num > median) {
            minHeap.remove(num);
        }else {
            if(num == minHeap.peek())
                minHeap.poll();
            else if(num == maxHeap.peek())
                maxHeap.poll();
        }
        balance();
    }

    private double findMedian() {
        if(minHeap.isEmpty() && maxHeap.isEmpty())
            return 0.0;
        if(minHeap.size() == maxHeap.size())
            return ((double)minHeap.peek() + (double) maxHeap.peek()) / 2.0d;
        else
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }

    private void balance() {
        if(minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.poll());
        } else if(maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian s = new SlidingWindowMedian();
        int[] a = new int[] {2147483647,1,2,3,4,5,6,7,2147483647};
        System.out.println(Arrays.toString(s.medianSlidingWindow(a, 2)));
    }

}
