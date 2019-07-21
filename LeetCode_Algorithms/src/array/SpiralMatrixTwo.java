package array;

import java.util.Arrays;

/**
 * #59
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * @author Ryan
 *
 */
public class SpiralMatrixTwo {

	public int[][] generateMatrix(int n) {
		if (n == 0)
			return null;
		int[][] m = new int[n][n];
		int k = 1;
		int r1 = 0, c1 = 0; // current position
		int r2 = n - 1, c2 = n - 1;// position need to to stopped
		while (k <= n * n) {
			for (int c = c1; c <= c2; c++) {
				m[r1][c] = k;
				k++;
			}
			r1++;

			if (k > n * n) continue;
			for (int r = r1; r <= r2; r++) {
				m[r][c2] = k;
				k++;
			}
			c2--;

			if (k > n * n) continue;
			for (int c = c2; c >= c1; c--) {
				m[r2][c] = k;
				k++;
			}
			r2--;

			if (k > n * n) continue;
			for (int r = r2; r >= r1; r--) {
				m[r][c1] = k;
				k++;
			}
			c1++;
		}
		return m;
	}

	public static void main(String[] args) {
		SpiralMatrixTwo sp2 = new SpiralMatrixTwo();
		System.out.println(Arrays.deepToString(sp2.generateMatrix(3)));
	}

}
