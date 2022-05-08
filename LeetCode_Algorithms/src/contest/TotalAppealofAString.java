package contest;

import java.util.HashMap;
import java.util.Map;

public class TotalAppealofAString {
    long acc;
    public long appealSum(String s) {
        acc = 0;
        Map<Character, Long> lastIndexMap = new HashMap<>();
        int n = s.length();
        long[] dp = new long[n];

        for(int i = 0; i < s.length(); i ++) {
            long cur = processChar(s, i, lastIndexMap);
            if(i == 0)
                dp[0] = cur;
            else
                dp[i] = dp[i - 1] + cur;
        }
        return dp[n - 1];
    }

    private long processChar(String s, int index, Map<Character, Long> map) {
        char c = s.charAt(index);
        long sum = (1 + index + 1) * (index + 1) / 2;
        sum -= acc;
        if(map.containsKey(c)) {
            sum -= map.get(c) + 1;
            acc += map.get(c) + 1;
        }
        map.put(c, (long) index);
        return sum;
    }

    public static void main(String[] args) {
        TotalAppealofAString t = new TotalAppealofAString();
        System.out.println(t.appealSum("abbca"));
    }
}
