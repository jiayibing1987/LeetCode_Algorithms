package thirtydayschallenge;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 */
public class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(K ,(a,b) ->
                a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1] );
        pq.addAll(Arrays.asList(points));

        for(int i=0; i<K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

}
