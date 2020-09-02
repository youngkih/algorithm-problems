package queue.CircularQueue;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/

class MyCircularQueue {

    int[] queue;
    int head, tail, size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];

        for(int i=0;i<k;i++){
            queue[i] = -1;
        }

        size = k;
        System.out.println("Size: "+k);
        head = 0;
        tail = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        queue[tail++] = value;
        tail %= size;
        System.out.print("[Enqueued "+value+"] ");
        printQueue();
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        queue[head++] = -1;
        head %= size;
        System.out.print("[Dequeued] ");
        printQueue();
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        // Add size to tail so that -1 does not return NullPointer exception
        return queue[(tail + size - 1) % size];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(head == tail && queue[head] == -1){
            return true;
        }else{
            return false;
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        boolean res = false;
        if(head==tail && queue[tail]!= -1){
            res = true;
        }else if(head>tail && head-tail==1 && queue[tail]!=-1){
            res = true;
        }else{
            res = false;
        }
        System.out.print("(isFull? "+ res + ")");
        printQueue();
        return res;
    }

    private void printQueue(){
        // Mute as it will timeout on printing out in large Dataset
        // System.out.print("Head: "+head+", Tail: "+tail+", queue: ");
        // for(int i = 0;i<size;i++){
        //     System.out.print(queue[i]+" ");
        // }
        // System.out.println("");
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */