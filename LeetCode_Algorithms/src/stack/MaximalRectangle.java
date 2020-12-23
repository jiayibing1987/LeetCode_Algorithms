package stack;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int max = 0;

        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            //update heights
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    heights[j] = heights[j] + 1;
                else
                    heights[j] = 0;
            }

            int[] left = new int[n]; //scan left to right, get last number which smaller than current heights[i]
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') {stack.push(j); continue;}
                while(stack.peek() >= 0 && heights[stack.peek()] >= heights[j]) {
                    stack.pop();
                }
                left[j] = stack.peek();
                stack.push(j);
            }

            stack = new Stack<>();
            stack.push(n);
            int[] right = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '0') {stack.push(j); continue;}
                while(stack.peek() < n && heights[stack.peek()] >= heights[j]) {
                    stack.pop();
                }
                right[j] = stack.peek();
                stack.push(j);
            }

            int area = 0;
            for(int j=0; j<n; j++) {
                area = Math.max(area, (right[j] - left[j] - 1) * heights[j]);
            }
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main (String[] args) {
         MaximalRectangle m = new MaximalRectangle();
         String[][] matrix = new String[][] {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
         System.out.println(m.maximalRectangle(convert(matrix)));
    }

    private static char[][] convert(String[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        char[][] res = new char[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                res[i][j] = matrix[i][j].charAt(0);
            }
        }
        return res;
    }

}
