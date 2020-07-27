package array.BestTimeToBuyAndSellStock2;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int buyPrice = 0;
        int res = 0;
        for(int i=0;i<prices.length;i++){
            int price = prices[i];
            if(price < min){
                min = price;
                buyPrice = price;
            }
            if(price > buyPrice){
                res += price - buyPrice;
                min = Integer.MAX_VALUE;
                i--; // After selling, buy it again
            }
        }

        return res;
    }
}