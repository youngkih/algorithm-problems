package pb9663;

import java.util.Scanner;

public class Pb9663Main {
    static int n, res;
    static boolean[][] matrix;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        res = 0;
        matrix = new boolean[n][n];

        Pb9663Main myMain = new Pb9663Main();
        myMain.solve(0, 0);
        System.out.println(res);
    }

    // Each row can only have 1 Queen, so pass 'row' as an argument and check that row only
    private void solve(int queenCnt, int row){
        if(queenCnt == n){
            res++;
            return;
        }

        for(int j=0;j<n;j++){
            if(isPlaceable(row, j)){
                matrix[row][j] = true;
                queenCnt++;

                solve(queenCnt, row+1);

                // Backtracking
                matrix[row][j] = false;
                queenCnt--;
            }
        }
    }

    private boolean isPlaceable(int x, int y){
        for(int i=0;i<n;i++){
            if(matrix[i][y])    // Column
                return false;

            if(matrix[x][i])    // Row
                return false;

            if((x-i >= 0) && (y+i) < n){ // Upper right
                if(matrix[x-i][y+i])
                    return false;
            }
            if((x-i >= 0) && (y-i) >= 0){ // Upper left
                if(matrix[x-i][y-i])
                    return false;
            }
            if((x+i < n) && (y+i) < n){ // Lower right
                if(matrix[x+i][y+i])
                    return false;
            }
            if((x+i < n ) && (y-i) >= 0){ // Lower left
                if(matrix[x+i][y-i])
                    return false;
            }
        }

        return true;
    }
}
