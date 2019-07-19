package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * #120
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * @author Ryan
 *
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size() == 0) return 0;
    	int row = triangle.size();
    	int[] array = new int[triangle.get(row-1).size()+1];
    	for(int i=row-1; i>=0; i--){
    		for(int j=0; j<triangle.get(i).size(); j++){
    			array[j] = triangle.get(i).get(j) + Math.min(array[j], array[j+1]);
    		}
    	}	
    	return array[0];
    }
    
    
	public static void main(String[] args) {
		Triangle t = new Triangle();
		List l1 = new ArrayList();
		l1.add(2);
		List l2 = new ArrayList();
		l2.add(3); l2.add(4);
		List l3 = new ArrayList();
		l3.add(6); l3.add(5); l3.add(7);
		List l4 = new ArrayList();
		l4.add(4); l4.add(1); l4.add(8); l4.add(3);
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);
		System.out.println(t.minimumTotal(triangle));
	}

}
