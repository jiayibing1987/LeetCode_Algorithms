package array;

/**
 * 463. Island Perimeter
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) continue;
                if(i-1 < 0 || grid[i-1][j] == 0) res++;
                if(j-1 < 0 || grid[i][j-1] == 0) res++;
                if(i+1 >= m || grid[i+1][j] == 0) res++;
                if(j+1 >= n || grid[i][j+1] == 0) res++;
            }
        }
        return res;
    }

}
