//Brute Force - T.C:O(N^2),S.C:O(256)
// class Solution {
//     public String minWindow(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         int sIndex = -1;
//         int minLen = Integer.MAX_VALUE;
//         for(int i=0;i<n;i++){
//             int[] hash = new int[256];
//             int count = 0;
//             for(int j = 0; j < t.length(); j++){
//                 hash[t.charAt(j)]++;
//             }
//             for(int j=i;j<n;++j){
//                 if(hash[s.charAt(j)]>0) count++;
//                 hash[s.charAt(j)]--;
//                 if(count == m){
//                     if(j-i+1 < minLen){
//                         minLen = j-i+1;
//                         sIndex = i;
//                         break;
//                     }
//                 }
//             }
//         }
//         return (sIndex == -1) ? "" : s.substring(sIndex,sIndex+minLen);
//     }
// }
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int sIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int count = 0;
        int[] hash = new int[256];
        for(int j = 0; j < m; j++){
            hash[t.charAt(j)]++;
        }
        while(r<n){          
            if(hash[s.charAt(r)]>0){
                count++;
            }
            hash[s.charAt(r)]--;
            
            while(count == m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0){
                    count--;
                } 
                l++;
            }
            r++;
        }
        return (sIndex == -1) ? "" : s.substring(sIndex,sIndex+minLen);
    }
}