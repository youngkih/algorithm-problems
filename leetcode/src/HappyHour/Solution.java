package HappyHour;

// NOTE
// - Using recursion
//   - Stack overflow - Tail recursion + Memoization
// - HashSet contains() time complexity
//   - O(1).
//   - https://www.baeldung.com/java-collections-complexity
//   - BUT using contains timed out while .add passed? https://stackoverflow.com/questions/628141/hashset-performance-add-vs-contains-for-existing-elements
// class Solution {
//     HashSet<Integer> checked = new HashSet<>();

//     public boolean isHappy(int n) {
//         int sum, remainder = 0;

//         while(!checked.contains(n)){
//         // while(checked.add(n)){
//             // System.out.println("n: " +n);
//             sum = 0;

//             while(n > 0){
//                 remainder = n % 10;
//                 sum += Math.pow(remainder, 2);
//                 n /= 10;
//             }

//             if(sum == 1){
//                 return true;
//             }
//             checked.add(n);
//             n = sum;
//         }
//         return false;
//     }
// }


// My solution using recursion
class Solution {
    HashSet<Integer> cache = new HashSet<>();

    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        if(cache.contains(n))
            return false;

        int sum = 0;
        int remainder = 0;

        cache.add(n);
        while(n > 0){
            remainder = n % 10;
            sum += Math.pow(remainder, 2);
            n = n / 10;
        }

        return isHappy(sum);
    }
}