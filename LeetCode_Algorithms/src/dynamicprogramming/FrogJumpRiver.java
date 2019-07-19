package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FrogJumpRiver {

	public boolean jump (int[] array){
		
		//init a map  to store stone's index and possible steps it can use in this stone
		int finalIndex = array[array.length-1];
		Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int i=0; i <array.length; i++) {
        	map.put(array[i], new HashSet<Integer>() );
        }
        map.get(0).add(1);
        
        for(int i=0; i<array.length-1; i++){
        	for(int k: map.get(array[i])){
        		//for each stone, try every possible index of river it can jump to
        		int jumpToIndex = k + array[i];
        		if(jumpToIndex == finalIndex) // if jump to end of river, return true
        			return true;
        		HashSet<Integer> set = map.get(jumpToIndex);
        		//set is not null means, there is a stone in this river index,then add other possible steps for that stone
        		if(set != null){
        		set.add(k - 1 > 0 ? k-1 : k);
        		set.add(k);   		    	
     		    set.add(k + 1);
        		}
        	}
        }   
        return false;
	}
	
	
	public static void main(String[] args) {
		FrogJumpRiver f = new FrogJumpRiver();
		int[] array1 = new int[]{0,1,3,5,6,8,12,17};//valid array
		System.out.println(f.jump(array1));
		
		int[] array2 = new int[]{0,1,2,3,9,17}; //not valid, 3 to 9 gap is too big
		System.out.println(f.jump(array2));
	}

}
