package thirtydayschallenge;

import java.util.Arrays;

public class SpiralMatrixTwo {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, left = 0;
        int bottom = n-1, right = n-1;
        Boolean leftToRight = true;
        Boolean topToBottom = null;

        int c = 1;
        int i = 0, j = 0;
        while(c <= n* n) {
            if(i == top && leftToRight != null && leftToRight ) {
                matrix[i][j++] = c++;
                if(j == right) {
                    top++;
                    leftToRight = null;
                    topToBottom = true;
                }
            } else if (j == right && topToBottom != null && topToBottom) {
                matrix[i++][j] = c++;
                if(i == bottom) {
                    topToBottom = null;
                    leftToRight = false;
                    right--;
                }
            } else if (i == bottom && leftToRight != null && !leftToRight) {
                matrix[i][j--] = c++;
                if(j == left) {
                    leftToRight = null;
                    topToBottom = false;
                    bottom--;
                }

            } else if (j == left && topToBottom != null && !topToBottom) {
                matrix[i--][j] = c++;
                if(i == top) {
                    topToBottom = null;
                    leftToRight = true;
                    left++;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixTwo sm = new SpiralMatrixTwo();
        System.out.println(Arrays.toString(sm.generateMatrix(4)));
        //[[1,2,3,4],
        // [12,13,14,5],
        // [11,0,15,6],
        // [10,9,16,7]]
    }
}
