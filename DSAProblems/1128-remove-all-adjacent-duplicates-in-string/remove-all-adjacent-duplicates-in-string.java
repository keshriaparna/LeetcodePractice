//Using stack and string builder
// class Solution {
//     public String removeDuplicates(String s) {
//         Stack<Character> st = new Stack<>();
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             if(st.isEmpty() || ch != st.peek()){
//                 st.push(ch);
//             }
//             else{
//                 st.pop();
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         for(char ch : st) {
//             sb.append(ch);
//         }
//         return sb.toString();
//     }
// }
//Using StringBuilder
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == ch){
                sb.deleteCharAt(sb.length() - 1);
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
