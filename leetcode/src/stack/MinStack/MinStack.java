package stack.MinStack;

// Problem: https://leetcode.com/problems/min-stack/submissions/
// 태호 Solution
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if(!minStack.isEmpty()){
            int min = Math.min(minStack.peek(), x);
            minStack.add(min);
        }else{
            minStack.add(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// My Solution using stack
// class MinStack {
//     Stack<Integer> stack;
//     int min;

//     /** initialize your data structure here. */
//     public MinStack() {
//         stack = new Stack<Integer>();
//         min = Integer.MAX_VALUE;
//     }

//     public void push(int x) {
//         stack.add(x);
//         if(min > x)
//             min = x;
//     }

//     public void pop() {
//         int res = stack.pop();
//         if(res == min){
//             min = findMin(stack);
//         }
//     }

//     public int top() {
//         return stack.peek();
//     }

//     public int getMin() {
//         return min;
//     }

//     private int findMin(Stack<Integer> stack){
//         int min = Integer.MAX_VALUE;
//         for(int i: stack){
//             if(i < min)
//                 min = i;
//         }

//         return min;
//     }
// } */