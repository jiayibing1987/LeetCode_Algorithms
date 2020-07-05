package dynamicprogramming;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumber {

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<>();
        long[] factors = {2,3,5};
        if(n < 1) return 0;
        pq.add(1L);
        set.add(1L);

        int count = 0;
        long res = 0;
        while ( count < n) {
            res = pq.poll();
            for(long factor : factors){
                if(!set.contains(res * factor)){
                    pq.add(res * factor);
                    set.add(res * factor);
                }
            }
            count ++;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        for(int i=1; i<=10; i++){
            System.out.println(u.nthUglyNumber(i));
        }
    }
}
