package pb17143;

import java.util.*;
import java.io.*;

class Shark{
    int size,x,y,speed,dir;

    Shark(int x, int y, int speed, int dir, int size){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dir = dir;
        this.size = size;
    }

    // Move only one section
    public void move(int max){
        if(dir == 1){ // up
            if(x == 0){
                this.dir = 2;
                this.x = x + 1;
            }else{
                this.x = x - 1;
            }
        }else if(dir == 2){ // down
            if(x == max - 1){
                this.dir = 1;
                this.x = x - 1;
            }else{
                this.x = x + 1;
            }
        }else if(dir == 3){ // right
            if(y == max - 1){
                this.dir = 4;
                this.y = y - 1;
            }else{
                this.y = y + 1;
            }
        }else{ // left
            if(y == 0){
                this.dir = 3;
                this.y = y + 1;
            }else{
                this.y = y - 1;
            }
        }
    }

    // Move speed amount of sections
    public void moveAll(int r, int c){
        int max;
        if(dir == 1 || dir == 2){
            max = r;
        }else{
            max = c;
        }
        int times = speed;
        while(times > 0){
            move(max);
            times--;
        }
    }
}

public class Pb17143Main{
    static int r, c, m;
    static Shark[][] board;
    static ArrayList<Shark> sharkList;
    static int res = 0;
    public static void main(String args[]) throws IOException {
        Pb17143Main m = new Pb17143Main();
        m.initializeBoard();

        for(int i=0;i<c;i++){
            m.catchShark(i);
            m.moveSharks();
            m.updateBoard();
        }
        System.out.println(res);
    }

    private void initializeBoard() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sharkList = new ArrayList<>();
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int y, x, s, d, z;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            sharkList.add(new Shark(x, y, s, d, z));
        }

// Using scanner consumes much more memory!
//        Scanner scan = new Scanner(System.in);
//        r = scan.nextInt(); // row num
//        c = scan.nextInt(); // col num
//        m = scan.nextInt(); // shark num
//
//        board = new Shark[r][c];
//        sharkList = new ArrayList<>();
//        for(int i=0;i<m;i++){
//            int sharkX = scan.nextInt()-1;
//            int sharkY = scan.nextInt()-1;
//            int sharkSpeed = scan.nextInt();
//            int sharkDir = scan.nextInt();
//            int sharkSize = scan.nextInt();
//            sharkList.add(new Shark(sharkX, sharkY, sharkSpeed, sharkDir, sharkSize));
//        }
        updateBoard();
    }

    private void moveSharks(){
        int size = sharkList.size();
        for(int i=0;i<size;i++){
            Shark s = sharkList.get(i);
            s.moveAll(r, c);
        }
    }

    private void catchShark(int y){
        for(int i=0;i<r;i++){
            if(board[i][y] != null){
                Shark s = board[i][y];
                sharkList.remove(s);
                res += s.size;
                return;
            }
        }
    }

    private void updateBoard(){
        board = new Shark[r][c];
        ArrayList<Shark> deletedSharkList = new ArrayList<>();

        for(int i=0;i<sharkList.size();i++){
            Shark s = sharkList.get(i);
            if(board[s.x][s.y] != null){
                Shark old_s = board[s.x][s.y];
                if(s.size > old_s.size){
                    board[s.x][s.y] = s;
                    deletedSharkList.add(old_s);
                }else{
                    deletedSharkList.add(s);
                }
            }else{
                board[s.x][s.y] = s;
            }
        }

        for(int i=0;i<deletedSharkList.size();i++){
            sharkList.remove(deletedSharkList.get(i));
        }
    }

    private void printBoard(){
        System.out.println("-------");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j] == null){
                    System.out.print("0");
                }else{
                    System.out.print(board[i][j].speed);
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}