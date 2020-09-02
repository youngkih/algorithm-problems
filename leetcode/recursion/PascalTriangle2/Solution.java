package recursion.PascalTriangle2;

// Problem: https://leetcode.com/problems/pascals-triangle-ii/
// Solution: https://www.youtube.com/watch?v=E--waEyRooY

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        if(rowIndex == 0){
            list.add(1);
            return list;
        }
        if(rowIndex == 1){
            list.add(1);
            list.add(1);
            return list;
        }
        List<Integer> previous = new ArrayList<>();
        previous.add(1);
        previous.add(1);

        for(int r=2;r<=rowIndex;r++){ // Iterate from row index 2
            List<Integer> next = new ArrayList<>();

            next.add(1); // First value is always 1
            for(int i=1;i<r;i++){
                next.add(previous.get(i-1) + previous.get(i));
            }
            next.add(1); // Last value is always 1

            previous = next;
        }

        return previous;
    }
}
