class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int min = prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]<min) min = prices[i];
            profit = Math.max(profit,prices[i]-min);
        }
        return profit;
    }
}
