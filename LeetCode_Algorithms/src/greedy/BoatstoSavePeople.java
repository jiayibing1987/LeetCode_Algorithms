package greedy;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 * @author Ryan
 *
 */
public class BoatstoSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int low = 0;
        int high = people.length-1;
        Arrays.sort(people);
        int res = 0;
        while(low < high){
    		high --;
    		res++;
        	if(people[low] + people[high] <= limit){
        		low++;
        	}else{ //only people[high] can fit into boat
        		//do nothing
        	}
        }
        if(low == high) res++;
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
