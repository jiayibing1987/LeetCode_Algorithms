package dynamicprogramming;

public class RegularExpressionMatching {

    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return helper(0, 0, s, p);
    }

    private boolean helper(int i, int j, String s, String p) {
        if(dp[i][j] != null)
            return dp[i][j];
        boolean res;
        if(j == p.length()) {
            res = i == s.length();
        } else {

            boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if(j <= p.length() -2 && p.charAt(j+1) == '*') {
                boolean discard = helper(i, j+2, s, p);
                boolean repeat = firstMatch && helper(i+1, j, s, p);
                res =  discard || repeat;
            } else {
                res =  firstMatch && helper(i+1, j+1, s, p);
            }
        }
        dp[i][j] = res;
        return res;
    }

    //1. brute force, back track
    public boolean isMatch1(String s, String p) {
        return backTrack(s, p);
    }

    private boolean backTrack(String s, String p) {
        if(p.isEmpty())
            return s.isEmpty();

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*') {
            boolean discard = backTrack(s, p.substring(2));
            boolean repeat = firstMatch && backTrack(s.substring(1), p);
            return discard || repeat;
        } else {
            if(!firstMatch)
                return false;
            else
                return backTrack(s.substring(1), p.substring(1));
        }
    }

}
