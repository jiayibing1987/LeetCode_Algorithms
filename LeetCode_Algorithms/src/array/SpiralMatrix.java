package array;

import java.util.ArrayList;
import java.util.List;

/**
 * #54
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * @author Ryan
 *
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length == 0) return list;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] used = new boolean[m][n];
        int i=0, j=0;
        Boolean leftToRight = true;
        Boolean topToBottom = null;
        while(list.size() < m*n){
        	if(topToBottom == null && leftToRight){
        		if(j==n || used[i][j]){
        			leftToRight = null;
        			topToBottom = true;
        			j--;
        			i++;
        			continue;
        		}else{
        			list.add(matrix[i][j]);
        			used[i][j] = true;
        			j++;
        		}
        	}else if(leftToRight==null && topToBottom){
        		if(i==m || used[i][j]){
        			leftToRight = false;
        			topToBottom = null;
        			i--;
        			j--;
        		}else{
        			list.add(matrix[i][j]);
        			used[i][j] = true;
        			i++;
        		}
        	}else if(topToBottom==null && leftToRight==false){
        		if(j==-1 || used[i][j]){
        			leftToRight = null;
        			topToBottom = false;
        			j++;
        			i--;
        		}else{
        			list.add(matrix[i][j]);
        			used[i][j] = true;
        			j--;
        		}
        	}else if(leftToRight == null && topToBottom == false){
        		if(used[i][j]){
        			leftToRight = true;
        			topToBottom = null;
        			i++;
        			j++;
        		}else{
        			list.add(matrix[i][j]);
        			used[i][j] = true;
        			i--;
        		}
        	}
        }
        return list;
    }
    
    
	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }};
		SpiralMatrix sm = new SpiralMatrix();
		System.out.println(sm.spiralOrder(m));
	}

}
