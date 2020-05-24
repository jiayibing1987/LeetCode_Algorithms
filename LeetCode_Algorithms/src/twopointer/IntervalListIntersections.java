package twopointer;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i=0, j=0;
        while(i<A.length && j<B.length) {
            int[] a = A[i], b = B[j];
            int[] mergedInterval = merge(a, b);
            if(mergedInterval != null)
                res.add(mergedInterval);

            if(a[1] > b[1])
                j++;
            else
                i++;
        }
        return res.toArray(new int[res.size()][2]);
    }

    private int[] merge (int[] a, int[] b) {
        if(a == null) return b;
        if(b == null) return a;
        if(a[0] > b[1] || b[0] > a[1]) return null;
        return new int[] {Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }

}
