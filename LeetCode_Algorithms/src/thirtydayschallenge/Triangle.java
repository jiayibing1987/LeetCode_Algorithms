package thirtydayschallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int[] preSum = new int[] {triangle.get(0).get(0)};
        for(int k = 1; k < triangle.size(); k++) {
            List<Integer> cur = triangle.get(k);
            int[] curSum = new int[cur.size()];
            Arrays.fill(curSum, Integer.MAX_VALUE);
            for(int i = 0; i < preSum.length; i++) {
                curSum[i] = Math.min(curSum[i], preSum[i] + cur.get(i));
                curSum[i+1] = Math.min(curSum[i+1], preSum[i] + cur.get(i+1));
            }
            preSum = curSum;
        }

        for(int pathSum : preSum) {
            min = Math.min(pathSum, min);
        }
        return min;
    }

}
