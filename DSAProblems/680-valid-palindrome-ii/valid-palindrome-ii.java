// Brute Force - T.C: O(n^2) - tried n possible deletions(by deleting each character) and for each new string checked it is palindrome or not , S.C: O(n) - each time a new string got as we deleted 1 character each time
// class Solution {
//     private boolean isPalindrome(String s){
//         int n = s.length();
//         int start = 0;
//         int end = n - 1;
//         while(start<end){
//             if(s.charAt(start)!=s.charAt(end)){
//                 return false;
//             }
//             start++;
//             end--;
//         }
//         return true;
//     }
//     public boolean validPalindrome(String s) {
//         int n = s.length();
//         for(int i=0;i<n;i++){
//             String newString = s.substring(0,i)+s.substring(i+1);
//             if(isPalindrome(newString)){
//                 return true;
//             }
//         }
//         return false;
//     }
// }
//Optimal Approach - T.C:O(N),S.C:O(1)
class Solution {
        private boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                boolean skipLeft = isPalindrome(s,left + 1,right);
                boolean skipRight = isPalindrome(s,left,right - 1);
                return skipLeft || skipRight;
            }
            left++;
            right--;
        }
        return true;
    }
}