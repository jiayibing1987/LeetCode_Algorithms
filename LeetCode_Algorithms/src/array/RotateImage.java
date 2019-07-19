package array;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * @author Ryan
 *
 */
public class RotateImage {

	//swap m[i][j] to m[j][i]
	/**
	 *  1 2 3
	 *  4 5 6
	 *  7 8 9
	 *  
	 *  1 4 7
	 *  2 5 8
	 *  3 6 9
	 *  
	 *  reverse each row m[i][j] m[i][n-1-j]
	 *  7 4 1
	 *  8 5 2
	 *  9 6 3
	 *  
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int n = matrix[0].length;
		//swap ij to ji
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		//reverse each row
		for(int i=0; i<n; i++){
			for(int j=0; j<n/2; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-1-j];
				matrix[i][n-1-j] = temp;
			}
		}
	}

	public void printGrid(int[][] a)
	{
		int n = a[0].length;
	   for(int i = 0; i < n; i++)
	   {
	      for(int j = 0; j < n; j++)
	      {
	         System.out.printf("%5d ", a[i][j]);
	      }
	      System.out.println();
	   }
	}
	public static void main(String[] args) {
		RotateImage r = new RotateImage();
		int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
		r.rotate(m);
		r.printGrid(m);
	}

}
