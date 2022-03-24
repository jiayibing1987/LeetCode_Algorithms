package greedy;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 * @author Ryan
 *
 */
public class BoatstoSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0; int j = people.length - 1;

        while(i <= j) {
            if(people[i] + people[j] <= limit ) {
                i ++;
                j --;
            } else {
                j --;
            }
            count ++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		BoatstoSavePeople b = new BoatstoSavePeople();
        System.out.println(b.numRescueBoats(new int[] {3,2,2,1}, 3));
	}

}
