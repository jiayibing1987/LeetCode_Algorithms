package backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 * #52 N-queens problem
 * use back track as solution
 * use 3 sets to store columns and two diagnose, each time we place a queen, update those 3 sets
 * col just the queen's column and diagnose 1 is (rowIndex-colIndex) and diagnose2 is (rowIndex+colIndex)
 * @author Ryan
 *
 */
public class NQueensTwo {

	int count;
	Set<Integer> cols = new HashSet<Integer>();
	Set<Integer> dia1 = new HashSet<Integer>(); // dia top left to right bottom 
	Set<Integer> dia2 = new HashSet<Integer>(); // dia bottom left to right top  

    public int totalNQueens(int n) {
    	count = 0;
    	backTrack(0, n);
    	return count;
    }
    
    public void backTrack(int rowIndex, int n){
    	if(rowIndex == n) count++;
    	for(int j=0; j<n; j++){
    		if(cols.contains(j) || dia1.contains(rowIndex-j) || dia2.contains(rowIndex+j))
    			continue;
    		cols.add(j);
    		dia1.add(rowIndex-j);
    		dia2.add(rowIndex+j);
    		backTrack(rowIndex+1, n);
       		cols.remove(j);
    		dia1.remove(rowIndex-j);
    		dia2.remove(rowIndex+j);
    	}
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
