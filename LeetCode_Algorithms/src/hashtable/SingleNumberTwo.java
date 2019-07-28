package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * #137
 * @author Ryan
 *
 */
public class SingleNumberTwo {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i:nums){
        	if(map.containsKey(i)){
        		if(map.get(i)==1)
        			map.put(i, 2);
        		else if(map.get(i)==2)
        			map.remove(i);
        	}else
        		map.put(i, 1);
        }
        return map.keySet().iterator().next();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
