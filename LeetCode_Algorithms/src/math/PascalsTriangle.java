package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * @author Ryan
 *
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(numRows == 0) return result;
    	List<Integer> firstRow = new ArrayList<Integer>();
    	firstRow.add(1);
    	result.add(firstRow);
    	
    	for(int i=0; i<numRows-1; i++){
    		List<Integer> lastRow = result.get(i);
    		List<Integer> currentRow = new ArrayList<Integer>();
    		currentRow.add(1);
    		for(int j=1; j<lastRow.size(); j++){
    			currentRow.add(j, lastRow.get(j-1)+lastRow.get(j));
    		}
    		currentRow.add(1);
    		result.add(currentRow);
    	}
    	return result;
    }
	
	public static void main(String[] args) {
		PascalsTriangle p = new PascalsTriangle();
		System.out.println(p.generate(5));
	}

}
