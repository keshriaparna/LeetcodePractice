// class StockSpanner {
//     List<Integer> list;

//     public StockSpanner() {
//         list = new ArrayList<>();
//     }
    
//     public int next(int price) {
//         list.add(price);
//         int count = 1;
//         for(int i = list.size() - 2; i >= 0; i--){
//             if(list.get(i)<=price) count++;
//             else break;
//         }
//         return count;
//     }
// }
class StockSpanner {
    Stack<int[]> st;
    int index;

    public StockSpanner() {
        st = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index++;
        while(!st.isEmpty() && st.peek()[0]<=price){
            st.pop();
        }
        int span;
        if(st.isEmpty()){
            span = index + 1;
        }
        else{
            span = index - st.peek()[1];
        }
        st.push(new int[]{price,index});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */