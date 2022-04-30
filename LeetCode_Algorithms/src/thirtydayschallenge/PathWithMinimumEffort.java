package thirtydayschallenge;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int m;
    int n;
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] processed = new boolean[m][n];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.add(new int[] {0, 0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int effort = cur[2];
            if(r == m - 1 && c == n - 1)
                return effort;

            processed[r][c] = true;
            for(int[] d : directions) {
                int x = r + d[0];
                int y = c + d[1];
                if(x < 0 || y < 0 || x >= m || y >= n || processed[x][y])
                    continue;
                int childEffort = Math.max(effort, Math.abs(heights[x][y] - heights[r][c]));
                int[] child = new int[] {x, y, childEffort};

                q.add(child);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort p = new PathWithMinimumEffort();
        int[][] g = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(p.minimumEffortPath(g));
    }
}
