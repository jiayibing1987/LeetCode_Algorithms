package hashtable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CountingElements {

    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for(int a : arr)
            set.add(a);
        int count = 0;
        for(int a : arr){
            if(set.contains(a+1))
                count++;
        }
        return count;
    }

}
