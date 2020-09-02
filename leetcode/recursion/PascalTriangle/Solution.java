package recursion.PascalTriangle;

// Problem: https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/1659/

class Solution {
    int[][] cache;

    public List<List<Integer>> generate(int numRows) {
        cache = new int[numRows][numRows];
        List<List<Integer>> resList = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            ArrayList<Integer> arrList = new ArrayList<>();
            for(int j=0;j<=i;j++){
                int num = helper(i, j);
                arrList.add(num);
            }
            resList.add(arrList);
        }
        return resList;
    }

    private int helper(int row, int col){
        int res;
        if(row == 0 || col == 0 || col == row)
            return 1;

        if(cache[row][col] != 0){
            return cache[row][col];
        }else{
            res = helper(row-1, col-1) + helper(row-1, col);
            cache[row][col] = res;
        }

        return res;
    }

}