package stack.KeysAndRooms;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1391/

class Solution {
    int roomNum;
    boolean[] visited;
    List<List<Integer>> roomsList;
    Stack<Integer> stack = new Stack<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        roomNum = rooms.size();
        if(roomNum == 1)
            return true;
        visited = new boolean[roomNum];
        roomsList = rooms;

        visited[0] = true;
        return dfs(rooms.get(0));
    }

    private boolean dfs(List<Integer> startRoomList){
        for(int start : startRoomList){
            stack.add(start);
        }
        while(!stack.isEmpty()){
            int curRoom = stack.pop();
            visited[curRoom] = true;
            if(allVisited())
                return true;
            List<Integer> nextRoomList = roomsList.get(curRoom);
            for(int next : nextRoomList){
                if(!visited[next]){
                    stack.add(next);
                }
            }
        }
        return false;
    }

    private boolean allVisited(){
        for(int i=0;i<roomNum;i++){
            if(visited[i] == false)
                return false;
        }
        return true;
    }

}