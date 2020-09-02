package PalindromeNumber;

// Problem: https://leetcode.com/problems/palindrome-number/

// Solution: https://leetcode.com/problems/palindrome-number/discuss/5127/9-line-accepted-Java-code-without-the-need-of-handling-overflow
//  - Runtime 7 ms, Memory 40.8 MB
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int rev = 0;
        int tmp = x;
        while(tmp != 0){
            rev = rev * 10 + tmp % 10;
            tmp = tmp/10;
        }
        return rev == x;
    }
}

// My Solution
//  - Runtime 8 ms, Memory 41 MB
// class Solution {
//     public boolean isPalindrome(int x) {
//         if(x < 0)
//             return false;
//         ArrayList<Integer> arrList = new ArrayList<>();
//         int tmp = x;
//         while(tmp >= 10){
//             arrList.add(tmp % 10);
//             tmp = tmp / 10;
//         }
//         arrList.add(tmp);

//         int res = 1;

//         for(int i=0;i<arrList.size();i++){
//             if(i == 0){
//                 res = arrList.get(i);
//                 continue;
//             }

//             res = res * 10 + arrList.get(i);
//         }

//         return (res == x);
//     }
// }