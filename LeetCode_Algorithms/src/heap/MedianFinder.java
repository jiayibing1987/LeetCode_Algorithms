package heap;

import java.util.*;

public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /**Min Max Heap*/
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(minHeap.isEmpty() || num <= minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if(minSize - maxSize >= 2) {
            maxHeap.add(minHeap.poll());
        } else if(maxSize - minSize >= 2) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return ((double)minHeap.peek() + (double) maxHeap.peek()) / 2.0d;
        else
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }
    /*    List<Integer> list;
     */

    /**
     * insertion sort with binary search
     *//*
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int index = binarySearch(list, num);
        if(index >= list.size())
            list.add(num);
        else
            list.add(index, num);
    }

    private int binarySearch (List<Integer> l, int target) {
        int low = 0;
        int high = list.size()-1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(target < list.get(mid)) {
                high = mid-1;
            } else if(target > list.get(mid)) {
                low = mid+1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public double findMedian() {
        int size = list.size();
        if(size % 2 == 1) {
            return list.get(size / 2);
        } else {
            return ((double)list.get(size / 2 - 1) + (double)list.get(size / 2)) / 2.0d;
        }
    }*/
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(6);
        System.out.println(m.findMedian());
        m.addNum(10);
        System.out.println(m.findMedian());
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(6);
        System.out.println(m.findMedian());
        m.addNum(5);
        System.out.println(m.findMedian());
        m.addNum(0);
        System.out.println(m.findMedian());
        m.addNum(6);
        System.out.println(m.findMedian());
    }

    /*    List<Integer> list;
     *//** 1.sorting **//*
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        int size = list.size();
        if(size % 2 == 1) {
            return list.get(size / 2);
        } else {
            return ((double)list.get(size / 2 - 1) + (double)list.get(size / 2)) / 2.0d;
        }
    }*/
}
