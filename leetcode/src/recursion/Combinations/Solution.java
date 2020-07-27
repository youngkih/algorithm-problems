package recursion.Combinations;

// Problem: https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/

class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(list);
        return resList;
    }

    private void backtrack(ArrayList<Integer> list){
        int start = 1;
        if(!list.isEmpty()){
            start = list.get(list.size()-1);
        }
        for(int i=start;i<=n;i++){ // This should make each list to be incremental order.
            if(isValid(i, list)){
                list.add(i);
                if(list.size() == k){
                    resList.add(new ArrayList<>(list)); // shallow copy of Arraylist. https://stackoverflow.com/questions/6536094/java-arraylist-copy
                }else{
                    backtrack(list);
                }
                list.remove(list.indexOf(i));
            }
        }
    }

    private boolean isValid(int i, ArrayList<Integer> list){
        boolean res = !list.contains(new Integer(i));
        return res;
    }
}