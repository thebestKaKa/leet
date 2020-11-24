package leet101_200;

public class leet121 {
    //股票最大利润
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length;i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }else if (prices[i] - minprice > maxProfit){
                maxProfit = prices[i] - minprice;
            }
        }
        return maxProfit;
    }
}
