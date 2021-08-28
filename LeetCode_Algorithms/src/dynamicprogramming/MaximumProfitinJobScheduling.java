package dynamicprogramming;

import java.util.*;

public class MaximumProfitinJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Node(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(list);

        int[] dp = new int [n];
        for(int i = 0; i < n; i++) {
            dp[i] = list.get(i).profit;
        }

        int max = dp[0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j ++) {
                if(list.get(i).start >= list.get(j).end) {
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).profit);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    class Node implements Comparable<Node> {
        int start;
        int end;
        int profit;

        public Node (int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }

        @Override
        public int compareTo (Node node) {
            if(node.start == this.start) {
                return this.end - node.end;
            }
            return this.start - node.start;
        }
    }

}
