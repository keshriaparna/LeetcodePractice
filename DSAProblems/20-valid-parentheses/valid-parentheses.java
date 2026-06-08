class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.isEmpty() || ch == '(' || ch == '[' || ch == '{'){
                st.push(s.charAt(i));
            }
            else {
                if(ch==')'){
                    if(st.peek()=='('){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                else if(ch==']'){
                    if(st.peek()=='['){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    if(st.peek()=='{'){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(st.size()==0) { return true; }
        else { return false; }
    }
}
