// L2: Best Time to Buy and Sell Stock
public class Problem_2 {

    static int maxProfit(int[] prices) {
        int minPriceSoFar = prices[0];
        int maxProfitSoFar = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitToday = prices[i] - minPriceSoFar;
            if (profitToday > maxProfitSoFar) {
                maxProfitSoFar = profitToday;
            }
            if (prices[i] < minPriceSoFar) {
                minPriceSoFar = prices[i];
            }
        }

        return maxProfitSoFar;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2));
    }
}
