package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {

    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> res = new ArrayList<>();
        String s = "";
        if(N == 1) res.add(0);
        for(int i=1; i<=9; i++) {
            dfs(res, N, K, i);
        }
        return res.stream().mapToInt(integer -> integer).toArray();
    }

    private void dfs (List<Integer> res, int N, int K, int s) {
        if(s >= Math.pow(10, N)) {
            res.add(s);
            return;
        }

        int lastDigit = s % 10;
        if(lastDigit - K >= 0)
            dfs(res, N, K, s * 10 + (lastDigit - K));
        if(lastDigit + K <= 9 && K != 0)
            dfs(res, N, K, s * 10 + (lastDigit + K));
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences n = new NumbersWithSameConsecutiveDifferences();
        System.out.print(Arrays.toString(n.numsSameConsecDiff(2, 1)));
    }

}
