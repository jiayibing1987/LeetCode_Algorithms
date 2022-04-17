package contest;

public class MaximumTrailingZerosinaCorneredPath {

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] leftRight = new long[m][n];
        long[][] topDown = new long[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    leftRight[i][j] = grid[i][j];
                else
                    leftRight[i][j] = grid[i][j] * leftRight[i][j - 1];
            }
            max = Math.max(findTailZeros(leftRight[i][n - 1]), max);
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i == 0)
                    topDown[i][j] = grid[i][j];
                else
                    topDown[i][j] = grid[i][j] * topDown[i - 1][j];
            }
            max = Math.max(findTailZeros(topDown[m - 1][j]), max);
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long left = j == 0 ? 1 : leftRight[i][j - 1];
                long right = leftRight[i][n - 1] / (leftRight[i][j]);
                long top = i == 0 ? 1 : topDown[i - 1][j];
                long down = topDown[m - 1][j] / (topDown[i][j]);

                int topleft = findTailZeros(left * top * grid[i][j]);
                max = Math.max(max, topleft);
                int topRight = findTailZeros(right * top * grid[i][j]);
                max = Math.max(max, topRight);
                int downleft = findTailZeros(left * down * grid[i][j]);
                max = Math.max(max, downleft);
                int downRight = findTailZeros(right * down * grid[i][j]);
                max = Math.max(max, downRight);
            }
        }
        return max;
    }

    private int findTailZeros(long num) {
        int zeroes = 0;
        while (num % 10 == 0 && num != 0) {
            zeroes++;
            num /= 10;
        }
        return zeroes;
    }

    public static void main(String[] args) {
        MaximumTrailingZerosinaCorneredPath m = new MaximumTrailingZerosinaCorneredPath();
        int[][] m1 = new int[][]{
                {824, 709, 193, 413, 701, 836, 727},
                {135, 844, 599, 211, 140, 933, 205},
                {329, 68, 285, 282, 301, 387, 231},
                {293, 210, 478, 352, 946, 902, 137},
                {806, 900, 290, 636, 589, 522, 611},
                {450, 568, 990, 592, 992, 128, 92},
                {780, 653, 795, 457, 980, 942, 927},
                {849, 901, 604, 906, 912, 866, 688}};
        System.out.println(m.maxTrailingZeros(m1));
    }

}
