package leet101_200;

public class leet122 {
    //股票最大利润 贪心算法
    public int maxProfit(int[] prices) {
        int peak = prices[0];
        int valley = prices[0];
        int ans = 0;
        int i = 0;
        while (i < prices.length - 1){
            //找到第一轮峰和谷
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            ans += peak - valley;
        }
        return ans;
    }

    public int maxProfit_plus(int[] prices) {
        //贪心算法
        int ans = 0;
        int i = 0;
        while(i < prices.length - 1){
            if (prices[i] < prices[i + 1])
                ans += prices[i + 1] - prices[i];
            i++;
        }
        return ans;
    }
}
