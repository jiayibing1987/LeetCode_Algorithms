package dynamicprogramming;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];

        buy[0] = - prices[0];
        sell[0] = 0;

        for(int i=1; i<prices.length; i++) {
            buy[i] = Math.max(buy[i-1], i -2 < 0 ?  - prices[i] : sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }

        return sell[prices.length-1];
    }

}
