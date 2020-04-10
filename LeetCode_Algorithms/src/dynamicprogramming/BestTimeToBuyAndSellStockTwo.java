package dynamicprogramming;

public class BestTimeToBuyAndSellStockTwo {

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int profit = 0;
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i+1] > prices[i])
                profit += prices[i+1] - prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        System.out.print(new BestTimeToBuyAndSellStockTwo().maxProfit(a));
    }
}
