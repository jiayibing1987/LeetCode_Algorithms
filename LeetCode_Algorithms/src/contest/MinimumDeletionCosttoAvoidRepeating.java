package contest;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class MinimumDeletionCosttoAvoidRepeating {

    public int minCost(String s, int[] cost) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        char[] chars = s.toCharArray();
        char curChar = chars[0];
        pq.add(cost[0]);

        for(int i=1; i<cost.length; i++) {
            char c = chars[i];
            if(c == curChar) {
                pq.add(cost[i]);
            } else {
                if(pq.size() > 1)
                    res += getCost(pq);
                curChar = c;
                pq.clear();
                pq.add(cost[i]);
            }
        }
        if(pq.size() > 1)
            res += getCost(pq);
        return res;
    }

    private int getCost(PriorityQueue<Integer> pq) {
        int size = pq.size();
        int count = 0;
        int res = 0;
        while(count < size -1) {
            res += pq.poll();
            count ++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumDeletionCosttoAvoidRepeating m = new MinimumDeletionCosttoAvoidRepeating();
        String s = "abaac";
        int[] cost = {1,2,3,4,5};
        System.out.println(m.minCost(s, cost));

        String s1 = "abc";
        int[] cost1 = {1,2,3};
        System.out.println(m.minCost(s1, cost1));

        String s2 = "aabaa";
        int[] cost2 = {1,2,3,4,1};
        System.out.println(m.minCost(s2, cost2));

        String s3 = "cddcdcae";
        int[] cost3 = {4,8,8,4,4,5,4,2};
        System.out.println(m.minCost(s3, cost3));
    }


}
