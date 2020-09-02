package queue.OpenTheLock;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1375/
// Solution: https://www.youtube.com/watch?v=IHT8Sx0832k

class Wheel{
    int val;
    Wheel(String s){
        this.val = Integer.parseInt(s);
    }

    public void increase(){
        if(this.val == 9){
            this.val = 0;
        }else{
            this.val++;
        }
    }

    public void decrease(){
        if(this.val == 0){
            this.val = 9;
        }else{
            this.val--;
        }
    }
}

class Solution {
    int cnt = -1;
    Wheel[] lock = new Wheel[4];
    Queue<Wheel[]> queue = new LinkedList<Wheel[]>();
    HashMap<String, Boolean> visited = new HashMap<String, Boolean>();

    private void initLock(){
        lock = new Wheel[4];
        for(int i=0;i<4;i++){
            lock[i] = new Wheel("0");
        }
    }

    private String getString(Wheel[] w){
        String res = "";
        for(int i=0;i<4;i++){
            res += Integer.toString(w[i].val);
        }
        return res;
    }

    public int openLock(String[] deadends, String target) {
        initLock();
        // System.out.println(getString(lock));
        // System.out.println(target);
        // System.out.println(target == getString(lock));
        for(String s : deadends){
            if(s.equals("0000"))
                return -1;
        }


        if(bfs(lock, deadends, target)){
            return cnt;
        }else{
            return -1;
        }
    }

    private boolean bfs(Wheel[] startWheel, String[] deadends, String target){
        queue.add(startWheel);
        visited.put(getString(startWheel), true);

        while(!queue.isEmpty()){
            int size = queue.size();
            cnt++;
            for(int i=0;i<size;i++){
                Wheel[] node = queue.poll();
                // System.out.println("Polled node: "+getString(node));

                if(getString(node).equals(target)){
                    // System.out.println("Target Found!");
                    return true;
                }

                Wheel[] newNode;

                for(int j=0;j<4;j++){
                    // +1 0 0 0
                    newNode = copyNode(node);
                    newNode[j].increase();
                    // System.out.println("Node Increase!" + getString(newNode));
                    if(!hasVisited(newNode)){
                        if(!isDeadend(newNode, deadends)){
                            queue.add(newNode);
                            // visited.put(getString(newNode), true);
                        }
                        visited.put(getString(newNode), true);
                    }

                    // -1 0 0 0
                    newNode = copyNode(node);
                    newNode[j].decrease();
                    // System.out.println("Node Decrease!" + getString(newNode));
                    if(!hasVisited(newNode)){
                        if(!isDeadend(newNode, deadends)){
                            queue.add(newNode);
                            // visited.put(getString(newNode), true);
                        }
                        visited.put(getString(newNode), true);
                    }
                }
            }

        }
        return false;
    }

    private Wheel[] copyNode(Wheel[] node){
        Wheel[] newNode = new Wheel[4];
        for(int i=0;i<4;i++){
            newNode[i] = new Wheel(Integer.toString(node[i].val));
        }
        return newNode;
    }

    private boolean isDeadend(Wheel[] node, String[] deadends){
        String str = getString(node);
        for(String s: deadends){
            if(str.equals(s)){
                return true;
            }
        }
        return false;
    }

    private boolean hasVisited(Wheel[] wheel){
        String str = getString(wheel);
        boolean res = false;
        if(visited.containsKey(str)){
            res = true;
        }
        // System.out.println(getString(wheel)+" visited? "+res);
        return res;
    }
}