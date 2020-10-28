package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;

        Pair cur = null;
        for(int n: nums) {
            if(cur == null) {
                cur = new Pair(n, n);
                continue;
            }
            if(cur.b == n - 1) {
                cur.b = n;
            } else {
                res.add(cur.toString());
                cur = new Pair(n, n);
            }
        }
        res.add(cur.toString());
        return res;
    }

    public class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            if(a == b) return String.valueOf(a);
            else return a + "->" + b;
        }
    }

    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        int[] a = {0,1,2,4,5,7};
        System.out.println(s.summaryRanges(a));
    }
}
