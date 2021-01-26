package graph;

import java.util.HashSet;
import java.util.Set;

public class PathWithMinimumEffort {

    int m;
    int n;
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        int low = 0;
        int high = findMax(heights);
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(canReach(heights, 0, 0, mid, new HashSet<>())) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private boolean canReach(int[][] heights, int i, int j, int k, Set<Integer> visited) {
        int key = i * n + j;
        if(visited.contains(key)) {
            return false;
        }
        if(i == m - 1 && j == n - 1) {
            return true;
        }

        visited.add(key);
        for(int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >= 0 && y >= 0 && x <= m - 1 && y <= n - 1 && Math.abs(heights[i][j] - heights[x][y]) <= k) {
                boolean found = canReach(heights, x, y, k, visited);
                if(found) return true;
            }
        }
        return false;
    }

    private int findMax(int[][] heights) {
        int max = 0;
        for(int i=0; i < m; i++) {
            for(int j=0; j<n; j++) {
                if(i < m-1) {
                    max = Math.max(max, Math.abs(heights[i+1][j] - heights[i][j]));
                }
                if(j < n-1) {
                    max = Math.max(max, Math.abs(heights[i][j+1] - heights[i][j]));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort p = new PathWithMinimumEffort();
        int[][] m1 = {{1,2,2},{3,8,2},{5,3,5}};
        int[][] m2 = {{1,10,6,7,9,10,4,9}};
        //System.out.println(p.minimumEffortPath(m1));
        System.out.println(p.minimumEffortPath(m2));
    }
}
