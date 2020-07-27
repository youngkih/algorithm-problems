package math.CountPrimes;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/

// Using Sieve of Eratosthenes
class Solution{
    boolean[] valid;

    public int countPrimes(int n){
        valid = new boolean[n];
        initializeValid();

        int cnt = 0;
        for(int i=2;i<n;i++){
            if(valid[i]){
                cnt++;
                updateValid(i, n);
            }
        }
        return cnt;
    }

    private void initializeValid(){
        for(int i=0;i<valid.length;i++){
            valid[i] = true;
        }
    }

    private void updateValid(int x, int n){
        for(int i=x;i<n;i+=x){
            valid[i] = false;
        }
    }
}

// Using brute-force
// 12 can be divided as below, but we can ignore the 4 x 3 and 6 x 2 because it's duplicate.
//  2 × 6 = 12
//  3 × 4 = 12
// ------------
//  4 × 3 = 12
//  6 × 2 = 12
//
// class Solution {
//     public int countPrimes(int n) {
//         int cnt = 0;
//         for(int i=2;i<n;i++){
//             if(isPrime(i)){
//                 cnt++;
//             }
//         }
//         return cnt;
//     }

//     private boolean isPrime(int n){
//         for(int i=2;i<=Math.sqrt(n);i++){ // Or for(int i=2;i*i<=n;i++)
//             if(n % i == 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }