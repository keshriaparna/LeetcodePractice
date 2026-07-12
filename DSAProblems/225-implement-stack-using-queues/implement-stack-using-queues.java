class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        int n = queue.size();
        for(int i=0;i<n-1;i++){
            queue.add(queue.remove());
        }
        return queue.remove();
    }
    
    public int top() {
        int n = queue.size();
        for(int i=0;i<n-1;i++){
            queue.add(queue.remove());
        }
        int top = queue.peek();
        queue.add(queue.remove());
        return top;
    }
    
    public boolean empty() {
        return queue.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */