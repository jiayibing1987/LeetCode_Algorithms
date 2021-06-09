package heap;

import java.util.*;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i = 0; i<nums.length; i++) {
            while(!pq.isEmpty() && pq.peek()[1] <= i - k) {
                pq.poll();
            }

            pq.add(new int[] {nums[i], i});
            if(i>= k-1)
                res[i-(k-1)] = pq.peek()[0];
        }
        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i = 0; i<nums.length; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }
            dq.offerLast(i);
            if(i>= k-1)
                res[i-(k-1)] = nums[dq.peekFirst()];
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(i < k) {
                add(map, nums, i);
                if(i == k-1) res.add(map.lastKey());
                continue;
            }

            add(map, nums, i);
            remove(map, nums, i-k);
            res.add(map.lastKey());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private void remove(TreeMap<Integer, Set<Integer>> map, int[] nums, int i) {
        if(!map.containsKey(nums[i])) {
            System.out.println("error while deleting index : " + i );
            return;
        }
        if(map.get(nums[i]).size() == 1) {
            map.remove(nums[i]);
        } else {
            Set set = map.get(nums[i]);
            set.remove(i);
        }
    }

    private void add (TreeMap<Integer, Set<Integer>> map, int[] nums, int i) {
        Set set;
        if(map.containsKey(nums[i])) {
            set = map.get(nums[i]);
            set.add(i);
        } else {
            set = new HashSet();
            set.add(i);
            map.put(nums[i], set);
        }
    }

    public static void main(String[] args) {
        SlidingWindowMaximum w = new SlidingWindowMaximum();
        int[] a = {1,3,-1,-3,5,3,6,7};
        //System.out.println(Arrays.toString(w.maxSlidingWindow2(a, 3)));
        System.out.println(Arrays.toString(w.maxSlidingWindow2(new int[] {1, -1}, 1)));
        //System.out.println(Arrays.toString(w.maxSlidingWindow(new int[] {9, 11}, 2)));
    }
}
