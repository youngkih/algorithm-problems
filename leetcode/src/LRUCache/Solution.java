// Problem: https://leetcode.com/problems/lru-cache/submissions/

package LRUCache;


// O(1) Solution
class Node{
    int key, value;
    Node prev, next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity = 0;
    Node tail = new Node(0, 0); // Dummy node
    Node head = new Node(0, 0); // Dummy node

    // Initialize
    public LRUCache(int capacity) {
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int value = node.value;

            removeNode(node);
            addNode(new Node(key, value));
            return value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            addNode(new Node(key, value));
        }else{
            if(map.size() == capacity){
                removeHead();
                addNode(new Node(key, value));
            }else{
                Node node = new Node(key, value);
                addNode(node);
            }
        }

    }

    // Remove the head(Not the dummy node) from the list
    private void removeHead(){
        map.remove(head.next.key);

        head.next = head.next.next;
        head.next.prev = head;
    }

    // Remove Node from the list
    private void removeNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node to the tail.(In front of dummy tail node)
    private void addNode(Node node){
        map.put(node.key, node);

        Node tailNode = tail.prev;
        tailNode.next = node;
        node.prev = tailNode;
        node.next = tail;
        tail.prev = node;
    }

}

// O(N) Solution
//class LRUCache {
//    int capacity;
//    HashMap<Integer, Integer> map = new HashMap<>();
//    ArrayList<Integer> keyList = new ArrayList<>();
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if(map.containsKey(key)){
//            keyList.remove(keyList.indexOf(key));
//            keyList.add(key);
//            return map.get(key);
//        }else{
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//        if(map.containsKey(key)){
//            keyList.remove(keyList.indexOf(key));
//        }else{
//            if(map.size() == capacity){
//                int leastKey = keyList.remove(0);
//                map.remove(leastKey);
//            }
//        }
//
//        keyList.add(key);
//        map.put(key, value);
//    }
//
//}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */