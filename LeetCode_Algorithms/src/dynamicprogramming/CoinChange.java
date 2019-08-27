package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * #322. Coin Change
 * @author Ryan
 *
 */
public class CoinChange {

	//brute force with memorization
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int coinChange1(int[] coins, int amount) {
    	Arrays.sort(coins);
    	return helper(coins, amount);
    }
    
    private int helper(int[] coins, int n){
    	if(n==0) return 0;
    	if(n<0) return -1;
    	if(map.containsKey(n)) return map.get(n);
    	int minDepth = Integer.MAX_VALUE;
    	for(int i=0; i<coins.length; i++){
    		int res = helper(coins, n-coins[i]);
    		map.put(n-coins[i], res);
    		if(res < 0) continue;
    		minDepth = Math.min(minDepth, res+1);
    	}
    	return minDepth == Integer.MAX_VALUE ? -1 : minDepth;
    }
    
    //dp solution bottom up
    public int coinChange(int[] coins, int amount) {
    	if(amount <=0) return 0;
    	int[] dp = new int[amount+1];
    	int max = 0;
    	for(int coin: coins){
    		if(coin <= amount) dp[coin] = 1;
    	}
    	for(int i=1; i<=amount-max; i++){
    		if(dp[i] == 0) continue;
    		for(int coin: coins){
    			if(coin>amount || i+coin > amount) continue;
    			if(dp[i+coin] == 0) dp[i+coin] = dp[i]+1;
    			else dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
    		}
    	}
    	return dp[amount] == 0 ? -1 : dp[amount];
    }

    
    
	public static void main(String[] args) {
		CoinChange c = new CoinChange();
		int[] a  ={2};
		int[] b = {1,2,5};
		int[] cc = {1,2147483647};
		int amounta = 3;
		int amountb = 11;
		int amountc = 2;
		System.out.println(c.coinChange(cc, amountc));
	}

}
