package dynamicprogramming;

/**
 * 121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1)
        	return 0;
        
        int min= prices[0];
        int max = 0;
    	for(int i=1; i<prices.length; i++){
    		min = Math.min(min, prices[i]);
    		max = Math.max(max, prices[i]-min);
    	}
    	
    	return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
