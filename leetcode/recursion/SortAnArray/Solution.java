package recursion.SortAnArray;

// Problem : https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2944/

class Solution {
    public List<Integer> sortArray(int[] nums) {
        int[] res = mergeSort(nums);
        List<Integer> list = new LinkedList<>();
        for(int i : res){
            list.add(i);
        }
        return list;
    }

    // Top-Down
    private int[] mergeSort(int[] input){
        if (input.length <= 1) {
            return input;
        }
        int pivot = input.length / 2;
        int [] leftArr = mergeSort(Arrays.copyOfRange(input, 0, pivot));
        int [] rightArr = mergeSort(Arrays.copyOfRange(input, pivot, input.length));
        return merge(leftArr, rightArr);
    }

    // Bottom-Up
//     private int[] mergeSort(int[] input){

//     }

    private int[] merge(int[] leftArr, int[] rightArr){
        int[] res = new int[leftArr.length + rightArr.length];
        int leftCursor = 0, rightCursor = 0, resCursor = 0;
        while(leftCursor < leftArr.length
                && rightCursor < rightArr.length){
            if(leftArr[leftCursor] < rightArr[rightCursor]){
                res[resCursor++] = leftArr[leftCursor++];
            }else{
                res[resCursor++] = rightArr[rightCursor++];
            }
        }
        while(leftCursor < leftArr.length){
            res[resCursor++] = leftArr[leftCursor++];
        }
        while(rightCursor < rightArr.length){
            res[resCursor++] = rightArr[rightCursor++];
        }
        return res;
    }


}