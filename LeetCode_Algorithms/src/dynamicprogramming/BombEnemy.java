package dynamicprogramming;

public class BombEnemy {

    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Node[][] res = new Node[m][n];

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                res[i][j] = new Node();
                if(grid[i][j] != 'W') {
                    if(i > 0)
                        res[i][j].up += res[i - 1][j].up;
                    if(j > 0)
                        res[i][j].left += res[i][j - 1].left;
                    if(grid[i][j] == 'E') {
                        res[i][j].up ++;
                        res[i][j].left ++;
                    }
                }
            }
        }

        for(int i = m - 1; i >= 0; i --) {
            for(int j = n - 1; j >= 0; j --) {
                if(grid[i][j] != 'W') {
                    if(i != m - 1)
                        res[i][j].down += res[i + 1][j].down;
                    if(j !=  n - 1)
                        res[i][j].right += res[i][j + 1].right;
                    if(grid[i][j] == 'E') {
                        res[i][j].down ++;
                        res[i][j].right ++;
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == '0') {
                    int value = res[i][j].getSum();
                    max = Math.max(max, value);
                }
            }
        }
        return max;
    }

    class Node {
        int up;
        int down;
        int left;
        int right;

        public int getSum() {
            return up + down + left + right;
        }

        @Override
        public String toString() {
            return up + " " + left + " " + down + " " + right;
        }
    }

    public static void main(String[] args) {
        BombEnemy b = new BombEnemy();
        char[][] ch1 = new char[][] {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
        System.out.println(b.maxKilledEnemies(ch1));
    }
}
