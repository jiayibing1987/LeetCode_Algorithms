package array;

import java.util.*;

/**
 * #1046
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b -a);
        for(int a : stones)
            q.add(a);
        while(q.size() > 1){
            int x = q.poll();
            int y = q.poll();
            q.add(x-y);
        }
        return q.peek();
    }

    public static void main (String[] args) {
        int[] a = {7,6,7,6,9};
        System.out.println(new LastStoneWeight().lastStoneWeight(a));
    }

}
