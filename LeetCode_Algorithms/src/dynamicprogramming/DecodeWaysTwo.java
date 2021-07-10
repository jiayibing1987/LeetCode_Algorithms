package dynamicprogramming;

public class DecodeWaysTwo {

    long m = 1000000000 + 7;
    public int numDecodings(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        long[] dp = new long[n];
        if (arr[0] >= '1' && arr[0] <= '9')
            dp[0] = 1;
        else if (arr[0] == '*')
            dp[0] = 9;

        for (int i = 1; i < n; i++) {
            char cur = arr[i];
            if (cur == '*') {
                dp[i] += dp[i - 1] * 9;

                char pre = arr[i - 1];
                long lastTwo = i > 1 ? dp[i - 2] : 1;
                if (pre == '*') {
                    dp[i] += lastTwo * 9;
                    dp[i] += lastTwo * 6;
                } else if (pre == '1') {
                    dp[i] += lastTwo * 9;
                } else if (pre == '2') {
                    dp[i] += lastTwo * 6;
                }
                dp[i] %= m;
            } else {
                int singleDigit = Character.getNumericValue(cur);
                if (singleDigit >= 1 && singleDigit <= 9)
                    dp[i] += dp[i - 1];

                char pre = arr[i - 1];
                if (pre == '*') {
                    dp[i] += i-2 < 0 ? 1 : dp[i-2];
                    if(singleDigit >= 0 && singleDigit <= 6)
                        dp[i] += i-2 < 0 ? 1 : dp[i-2];
                } else {
                    int doubleDigit = Integer.valueOf(s.substring(i-1, i+1));
                    if (doubleDigit >= 10 && doubleDigit <= 26) {
                        dp[i] += i-2 < 0 ? 1 : dp[i-2];
                    }
                }
                dp[i] %= m;
            }
        }
        return (int) (dp[n - 1] % m);
    }

    public static void main(String[] args) {
        DecodeWaysTwo d = new DecodeWaysTwo();
        System.out.println(d.numDecodings("1*"));
        System.out.println(d.numDecodings("2*"));
        System.out.println(d.numDecodings("*1"));
        System.out.println(d.numDecodings("***"));
        System.out.println(d.numDecodings("*1*1*0"));
        System.out.println(d.numDecodings("*10*1"));
    }
}
