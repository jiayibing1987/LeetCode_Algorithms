package dynamicprogramming;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class UglyNumber {

    public int nthUglyNumber(int n) {
        TreeSet<Long> treeSet = new TreeSet<>();
        long[] factors = {2,3,5};
        if(n < 1) return 0;
        treeSet.add(1L);

        for(int i=1; i<n; i++) {
            long temp = treeSet.pollFirst();
            for(long factor : factors){
                treeSet.add(temp * factor);
            }
        }
        return treeSet.first().intValue();
    }

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        for(int i=1; i<=10; i++){
            System.out.println(u.nthUglyNumber(i));
        }
    }
}
