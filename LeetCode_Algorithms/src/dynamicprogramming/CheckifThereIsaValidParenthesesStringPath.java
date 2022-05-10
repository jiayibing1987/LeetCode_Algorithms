package dynamicprogramming;

public class CheckifThereIsaValidParenthesesStringPath {

    int m;
    int n;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][][] memo = new boolean[m][n][m + n];
        return helper(grid, memo, 0, 0, 0);
    }

    private boolean helper(char[][] grid, boolean[][][] memo, int balance, int i, int j) {
        if(grid[i][j] == '(')
            balance ++;
        else
            balance --;

        int step = i + j + 1;
        int remain = m + n - 1 - step;
        if(i == m - 1 && j == n - 1 && balance == 0)
            return true;
        if(balance < 0 || balance > remain || memo[i][j][balance])
            return false;

        memo[i][j][balance] = true;
        if(i < m - 1 && helper(grid, memo, balance, i + 1, j))
            return true;
        if(j < n - 1 && helper(grid, memo, balance, i, j + 1))
            return true;
        return false;
    }

    public static void main(String[] args) {
        CheckifThereIsaValidParenthesesStringPath c = new CheckifThereIsaValidParenthesesStringPath();
        char[][] g = new char[][] {{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}};
        System.out.println(c.hasValidPath(g));
    }
}
