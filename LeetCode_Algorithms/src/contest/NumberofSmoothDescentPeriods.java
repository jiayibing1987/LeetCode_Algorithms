package contest;

import java.util.Arrays;

public class NumberofSmoothDescentPeriods {

    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long res = 0;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if(prices[i] == prices[i - 1] - 1) {
                len ++;
            } else {
                res += calc(len);
                len = 1;
            }
        }
        return res + calc(len);
    }

    private long calc(long n) {
        return ((1 + n) * n) / 2;
    }


//    private void backTrack(int[] prices, int index, int lastDigit, int len) {
//        if(index >= prices.length) return;
//        if (prices[index] == lastDigit - 1 || lastDigit <= 0) {
//            res += len + 1;
//            backTrack(prices, index + 1, prices[index], len + 1);
//        }
//    }

    public static void main(String[] args) {
        NumberofSmoothDescentPeriods n = new NumberofSmoothDescentPeriods();
        int[] p1 = new int[]{8, 6, 7, 7};
        System.out.println(n.getDescentPeriods(p1));
        int[] p2 = new int[] {3,2,1,4};
        System.out.println(n.getDescentPeriods(p2));
        int[] p3 = new int[] {3,2,1,3,2,1};
        System.out.println(n.getDescentPeriods(p3));
    }
}
