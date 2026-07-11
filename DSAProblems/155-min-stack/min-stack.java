class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        if(st.size() == 0){
            min = value;
            st.push(0L);
            return;
        }
        st.push(value-min);
        if(value<min){
            min = value;
        }
    }
    
    public void pop() {
        long rem = st.pop();
        if(rem < 0){
            long value = rem;
            min = min - rem;
        }
        else{
            long value = min + rem;
        }
    }
    
    public int top() {
        long rem = st.peek();
        if(rem < 0){
            long value = min;
            return (int)value;
        }else{
            long value = min + rem;
            return (int)value;
        }
    }
    
    public int getMin() {
        if(st.size()==0) return -1;
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */