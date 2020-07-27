package pb2580;

import java.util.*;

class Node{
    int x, y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Pb2580Main{
    static int[][] board = new int[9][9];
    static boolean isEnded = false;
    static ArrayList<Node> zeroList = new ArrayList<>();

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int n = scan.nextInt();
                board[i][j] = n;
                if(board[i][j] == 0){
                    zeroList.add(new Node(i, j));
                }
            }
        }

        Pb2580Main myMain = new Pb2580Main();
        myMain.solve(0);
    }

    private void solve(int idx){
        if(isEnded) // Use this flag to escape because we only need to print 1 solution
            return;
        if(idx == zeroList.size()){
            printBoard();
            isEnded = true;
            return;
        }

        Node node = zeroList.get(idx);
        int x = node.x;
        int y = node.y;

        for(int n=1;n<=9;n++){
            if(isPlaceable(x, y, n)){
                board[x][y] = n;
                solve(idx+1);
                if(isEnded)
                    return;
                board[x][y] = 0;
            }
        }
    }

    private boolean isPlaceable(int x, int y, int num){
        if(board[x][y] != 0)
            return false;

        for(int i=0;i<9;i++){
            if(board[x][i] == num){ // Check row
                return false;
            }
            if(board[i][y] == num){ // Check column
                return false;
            }
        }

        // Check the grid
        int xStart = (x / 3) * 3;
        int yStart = (y / 3) * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int X = xStart + i;
                int Y = yStart + j;
                if(board[X][Y] == num)
                    return false;
            }
        }

        return true;
    }

    private void printBoard(){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}