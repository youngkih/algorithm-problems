package dynamicprogramming.BestTimeToBuyAndSellStock;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/

class Solution {
    int max = Integer.MIN_VALUE;
    public int maxProfit(int[] prices) {
        for(int i=0;i<prices.length;i++){
            int boughtPrice = prices[i];
            helper(prices, boughtPrice, i);
        }
        if(max < 0)
            return 0;
        return max;
    }
    private void helper(int[] prices, int boughtPrice, int date){
        if(date == prices.length)
            return;

        if(prices[date] - boughtPrice > max){
            max = prices[date] - boughtPrice;
        }

        helper(prices, boughtPrice, date+1);
    }

}