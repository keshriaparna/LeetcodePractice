class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> stringStack = new ArrayDeque<>();
        int currentCount = 0;
        String currentString = "";
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                currentCount = currentCount * 10 + (ch - '0');
            }
            else if(ch == '['){
                countStack.push(currentCount);
                stringStack.push(currentString);
                currentCount = 0;
                currentString = "";
            }
            else if(ch == ']'){
                int repeatTimes = countStack.pop();
                StringBuilder repeatedString = new StringBuilder();
                for(int i=0;i<repeatTimes;i++){
                    repeatedString.append(currentString);
                }
                currentString = stringStack.pop() + repeatedString.toString();
            }
            else{
                currentString += ch;
            }
        }
        return currentString;
    }
}