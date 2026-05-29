// Brute Force - T.C: O(N^2)-> iterating array twice using 2 loops, S.C: O(256) - hash array
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         int maxLen = 0; // initialized as zero because string can be empty in that case length will be zero so it will return maxLength as zero.
//         for(int i=0;i<n;i++){
//             int[] hash = new int[256];
//             Arrays.fill(hash,0);
//             for(int j=i;j<n;j++){
//                 if(hash[s.charAt(j)] == 1) break;
//                 hash[s.charAt(j)] = 1;
//                 int len = j-i+1;
//                 maxLen = Math.max(maxLen, len);
//             }
//         }
//         return maxLen;
//     }
// }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int[] hash = new int[256];
        Arrays.fill(hash,-1);
        while(r<n){
            if(hash[s.charAt(r)] != -1){
                l = Math.max(hash[s.charAt(r)] + 1, l);
            } 
            int len = r - l + 1;
            maxLen = Math.max(len,maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}