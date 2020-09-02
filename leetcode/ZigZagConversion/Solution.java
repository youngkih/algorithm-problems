package ZigZagConversion;

// Problem: https://leetcode.com/problems/zigzag-conversion/

class Solution {

    int n, m;
    String[][] res;
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        this.n = numRows;
        this.m = getM(s, numRows);
        System.out.println("n,m:"+n+","+m);
        res = new String[n][m];
        zigzag(s, 0, 0 , 0);
        return returnRes();
    }

    private int getM(String s, int numRows){
        int lastIndex = s.length() - 1; // If strlen = 14 , lastIndex = 13.
        int nextIndex = 2 * (numRows - 1); // Second number of the index in first row
        int k = 1;

        while(nextIndex * k < lastIndex){
            k++;
        }
        if(k == 1){
            return nextIndex;
        }else{
            return nextIndex * (k - 1) + 1;
        }
    }

    private void zigzag(String str, int idx, int row, int col){
        while(idx < str.length()){
            // Go down
            for(int i=1;i<n;i++){
                res[row][col] = str.substring(idx, idx+1);
                row++;
                idx++;
                if(idx == str.length())
                    return;
            }

            // Go Upper Right
            for(int i=1;i<n;i++){
                res[row][col] = str.substring(idx, idx+1);
                row--;
                col++;
                idx++;
                if(idx == str.length())
                    return;
            }
        }
    }

    private void printRes(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private String returnRes(){
        String result = "";
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(res[i][j]!=null){
                    result += res[i][j];
                }
            }
        }
        return result;
    }

}