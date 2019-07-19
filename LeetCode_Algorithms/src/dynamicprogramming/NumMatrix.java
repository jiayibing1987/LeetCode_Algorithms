package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class NumMatrix {

	int[][] sumsMatrix;

	public NumMatrix(int[][] matrix) {
		if(matrix == null) return;
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 || col == 0 )return;
		sumsMatrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			int sum = 0;
			for (int j = 0; j < col; j++) {
				sum += matrix[i][j];
				sumsMatrix[i][j] = sum;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if(sumsMatrix == null || sumsMatrix.length == 0) return 0;
		int sum = 0;
		for (int i = row1; i <= row2; i++) {
			sum += sumsMatrix[i][col2] - (col1 == 0 ? 0 : sumsMatrix[i][col1 - 1]);
		}
		return sum;
	}
	
//	public int[][] matrix;
//	public NumMatrix(int[][] matrix) {
//	    for(int i=0;i<matrix.length;i++)
//	        for(int j=1;j<matrix[0].length;j++)
//	            matrix[i][j]+=matrix[i][j-1];
//	    this.matrix=matrix;
//	}
//
//	public int sumRegion(int row1, int col1, int row2, int col2) {
//	    int n=0;
//	    if(col1==0) for(int i=row1;i<=row2;i++) n+=matrix[i][col2];
//	    else for(int i=row1;i<=row2;i++) n+=matrix[i][col2]-matrix[i][col1-1];
//	    return n;
//	}

	public static void main(String[] args) {
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		int[][] a = {{}};
		NumMatrix n = new NumMatrix(a);
		System.out.println(n.sumRegion(1, 2, 2, 4));
	}

}
