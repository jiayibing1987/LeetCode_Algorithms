package breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {

    private int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                if (node[0] == n - 1 && node[1] == n - 1) return count;
                    for (int j = 0; j < dir.length; j++) {
                        int x = node[0] + dir[j][0];
                        int y = node[1] + dir[j][1];
                        if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0) {
                            grid[x][y] = 1;
                            q.add(new int[]{x, y});
                        }
                    }
            }
            count++;
        }
        return -1;
    }

}
