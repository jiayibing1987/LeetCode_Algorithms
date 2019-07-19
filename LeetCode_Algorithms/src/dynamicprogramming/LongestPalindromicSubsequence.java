package dynamicprogramming;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
    	if(s==null || s.isEmpty())
    		return 0;
    	
        char[] c = s.toCharArray();      
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i<s.length(); i++){
        	for(int j=0; j<i; j++){
        		if(c[i] == c[j]){
        			dp[i] = Math.max(dp[i], dp[j]+1);
        			max = Math.max(dp[i],max);
        		}
        	}
        }
        return max;
    }
    
    
	public static void main(String[] args) {
		String s1 = "bbbab";
		String s2 = "cbbd";
		String s3 = "aabaa";
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		System.out.println(lps.longestPalindromeSubseq(s1)); 
		System.out.println(lps.longestPalindromeSubseq(s2));
		System.out.println(lps.longestPalindromeSubseq(s3));

	}

}
