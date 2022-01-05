package backtrack;

public class PalindromePartitioningTwo {

    int n;
    Integer[] cutMemo;
    Boolean[][] pMemo;
    public int minCut(String s) {
        n = s.length();
        cutMemo = new Integer[n];
        pMemo = new Boolean[n][n];
        return helper(s, 0);
    }

    private int helper(String s, int start) {
        if(start == s.length()) return 0;
        if(cutMemo[start] != null)
            return cutMemo[start];

        int res = Integer.MAX_VALUE;
        for(int j = start; j < s.length(); j ++) {
            String sub = s.substring(start, j + 1);
            if(isPalindorme(s, start, j)) {
                int temp = helper(s, j + 1) +  (j == s.length() - 1 ? 0 : 1);
                res = Math.min(temp, res);
            }
        }
        cutMemo[start] = res;
        return res;
    }

    private boolean isPalindorme(String s, int i, int j) {
        if (i >= j) return true;
        if(pMemo[i][j] != null) return pMemo[i][j];

        boolean res = (s.charAt(i) == s.charAt(j)) && isPalindorme(s, i + 1, j - 1);

        pMemo[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        PalindromePartitioningTwo p = new PalindromePartitioningTwo();
        System.out.println(p.minCut("aab"));
    }
}
