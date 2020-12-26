package thirtydayschallenge;

public class DecodeWays {

    public int numDecodings(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int[] dp = new int[n];
        if(array[0] >= '1' && array[0] <= '9')
            dp[0] = 1;

        for(int i=1; i<n; i++) {
            int singleDigit = Character.getNumericValue(array[i]);
            int doubleDigits = Integer.valueOf(new StringBuilder().append(array[i-1]).append(array[i]).toString());

            int singleValue = 0;
            int doubleValue = 0;
            if(singleDigit >= 1 && singleDigit <=9)
                singleValue = dp[i-1];
            if(doubleDigits >= 10 && doubleDigits <= 26)
                doubleValue = i-2 < 0 ? 1 : dp[i-2];
            dp[i] = singleValue + doubleValue;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("226"));
        System.out.println(d.numDecodings("0"));
        System.out.println(d.numDecodings("1"));
    }
}
