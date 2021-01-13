package thirtydayschallenge;

import java.util.Arrays;
import java.util.Collections;

public class BoatstoSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0;
        int j = people.length - 1;
        while(i <= j) {
            if(i == j) return count + 1;
            if(people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,2,1};
        System.out.println(new BoatstoSavePeople().numRescueBoats(a, 3));
    }
}
