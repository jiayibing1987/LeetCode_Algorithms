package depthfirstsearch;

public class UniquePathsThree {
    int startRow;
    int startColumn;
    int numberOfSquares;
    int m;
    int n;
    int res;
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        init(grid);
        dfs(startRow, startColumn, 0, grid);
        return res;
    }

    private void dfs(int row, int col, int count, int[][] grid) {
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == -1) {
            return;
        }
        if(grid[row][col] == 3)
            return;
        if(grid[row][col] == 2 && count == numberOfSquares) {
            res ++;
            return;
        }

        int[] rowOffSet = {-1, 1, 0, 0};
        int[] colOffSet = {0, 0, -1, 1};
        if(grid[row][col] == 0) count ++;
        int oldValue = grid[row][col];
        grid[row][col] = 3;
        for(int i=0; i<=3; i++) {
            int nextRow = row + rowOffSet[i];
            int nextCol = col + colOffSet[i];
            dfs(nextRow, nextCol, count, grid);
        }
        grid[row][col] = oldValue;
    }

    private void init(int[][] grid) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    startRow = i;
                    startColumn = j;
                }else if(grid[i][j] == 0){
                    numberOfSquares ++;
                }
            }
        }
    }
}
