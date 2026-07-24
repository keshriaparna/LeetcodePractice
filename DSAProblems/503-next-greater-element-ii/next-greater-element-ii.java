// Brute Force - Using Circular Array Approach, T.C: O(N^2) , S.C: O(N) - ans array(outtput array)
// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[n];
//         Arrays.fill(ans,-1);
//         for(int i = 0; i < n ; i++){
//             int currEle = nums[i];
//             for(int j = 0; j < n; j++){
//                 int ind = (i+j) % n;
//                 if(nums[ind] > currEle){
//                     ans[i] = nums[ind];
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }
// Optimal Approach - Doubling the array hypothetically(using modulo operator to get actual index value) and using monotonic stack, maintaining the decreasing order. T.C: O(4N) which is equivalent to O(N), S.C: O(2N) + O(N) -> 2N for stack, in worst case we will store 2N elements and pop 2N elements from the stack and O(N) for answer array.
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i= 2*n - 1; i >= 0; i--){
            int ind = i % n;
            int currEle = nums[ind];
            while(!st.isEmpty() && st.peek()<= currEle){
                st.pop();
            }
            if(i<n){
                ans[i] = st.isEmpty()? -1 : st.peek();
            }
            st.push(currEle);
        }
        return ans;
    }
}