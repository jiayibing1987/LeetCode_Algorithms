package heap;

import java.util.*;

public class KClosestPointstoOrigin {

    //Binary Search
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] res = new int[k][2];

        List<Integer> resIndices = new ArrayList<>();
        List<Integer> searchIndices = new ArrayList<>();
        long[] distances = new long[n];
        long high = 0;
        for(int i = 0; i < n; i ++) {
            distances[i] = getDistance(points[i][0], points[i][1]);
            searchIndices.add(i);
            high = Math.max(high, distances[i]);
        }

        long low = 0;
        int x = k;
        while(x > 0) {
            long mid = low + (high - low) / 2;
            List<Integer>[] splittedLists = split(mid, distances, searchIndices);
            List<Integer> smaller = splittedLists[0];
            List<Integer> larger = splittedLists[1];
            if(smaller.size() > x) {
                searchIndices = smaller;
                high = mid;
            } else {
                searchIndices = larger;
                x -= smaller.size();
                resIndices.addAll(smaller);
                low = mid + 1;
            }
        }

        for(int i = 0; i < k; i ++) {
            int[] point = points[resIndices.get(i)];
            res[i] = point;
        }
        return res;
    }

    public List<Integer>[] split (long mid, long[] distances, List<Integer> searchIndices) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();
        for(int i : searchIndices) {
            if(distances[i] <= mid) {
                smaller.add(i);
            } else {
                larger.add(i);
            }
        }
        return new List[] {smaller, larger};
    }

    //HEAP
    public int[][] kClosest1(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int) (b[1] - a[1]));
        for(int i = 0; i < n; i ++) {
            int x = points[i][0];
            int y = points[i][1];
            long d = getDistance(x, y);
            pq.add(new long[] {i, d});
            if(pq.size() > k)
                pq.poll();
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i ++) {
            int index = (int)pq.poll()[0];
            res[i] = points[index];
        }
        return res;
    }

    public long getDistance(int x, int y) {
        return (long) x * (long) x + (long) y * (long) y;
    }

    public static void main(String[] args) {
        KClosestPointstoOrigin kc = new KClosestPointstoOrigin();
        int[][] a1 = new int[][] {{1, 3}, {-2, 2}};
        System.out.println(Arrays.toString(kc.kClosest(a1, 1)));
    }
}
