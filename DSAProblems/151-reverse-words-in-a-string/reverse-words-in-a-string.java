//Brute Force - T.C: O(n), S.C:O(n)
// class Solution {
//     public String reverseWords(String s) {
//         int n = s.length();
//         List<String> words = new ArrayList<>();
//         int start,end;
//         int i = 0;
//         while(i<n){
//             while(i<n && s.charAt(i) == ' ') i++;
//             if(i >= n) break;
//             start = i;
//             while(i<n && s.charAt(i) != ' ') i++;
//             end = i-1;
//             String wordFound = s.substring(start, end + 1);
//             words.add(wordFound);  
//         }
//         StringBuilder ans = new StringBuilder();
//         for(int j = words.size() - 1;j >= 0;j--){
//             ans.append(words.get(j));
//             if(j!=0) ans.append(' ');
//         }
//         return ans.toString();
//     }
// }
// Optimal - T.C: O(n), S.C:O(1)
class Solution {
    private static void reverseString(StringBuilder s, int start, int end){
        while(start < end){
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb,0,n-1);
        int i = 0,j = 0,start = 0, end = 0;
        while(j<n){
            while(j<n && sb.charAt(j) == ' ') j++;
            if(j==n) break;
            start = i;
            while(j<n && sb.charAt(j) != ' ') {
                if(i < sb.length()){
                    sb.setCharAt(i++,sb.charAt(j++));
                }
                else{
                    sb.append(sb.charAt(j++));
                    i++;
                }
            }
            end = i - 1;
            reverseString(sb, start, end);
            if(j<n){
                if(i<sb.length()) {
                    sb.setCharAt(i++, ' ');
                }
                else{
                    sb.append(' ');
                    i++;
                }
            }
        }
        if(i>0 && sb.charAt(i-1) == ' ') i--;
        return sb.substring(0,i);
    }
}