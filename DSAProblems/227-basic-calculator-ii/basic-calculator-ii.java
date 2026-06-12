class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char operator = '+';
        int currentNumber = 0;
        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            if(i == s.length()-1 || currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/'){
                if(operator == '+'){
                    st.push(currentNumber);
                }
                else if(operator == '-'){
                    st.push(-currentNumber);
                }
                else if(operator == '*'){
                    st.push(st.pop() * currentNumber);
                }
                else if(operator == '/'){
                    st.push(st.pop() / currentNumber);
                }
                operator = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}