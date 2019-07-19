package dynamicprogramming;

public class DecodeWays {

    public int numDecodings(String s) {
    	if(s == null || s.isEmpty())
    		return 0;
        int n = s.length();
        int dp[] = new int[n+1];
       // dp[0] = 1;
        dp[0] = s.charAt(0)!='0'? 1 : 0;
        
        for(int i=1; i<n; i++){
        	int first = Integer.valueOf( i>=n ? s.substring(i) : s.substring(i, i+1));
        	int second = Integer.valueOf(s.substring(i-1, i>=n ? i : i+1));
        	
        	if(first >= 1 && first <= 9)
        		dp[i] += dp[i-1];
        	if(second >= 10 && second <= 26)
        		dp[i] += i==1? 1 : dp[i-2];
        }
        return dp[n-1];
    }
	
	public static void main(String[] args) {
		DecodeWays d = new DecodeWays();
		System.out.println(d.numDecodings("12"));
	}

}
