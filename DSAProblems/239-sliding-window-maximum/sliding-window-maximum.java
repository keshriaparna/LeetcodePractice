//Brute Force - O(N-k)*k, S.C: O(1)
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int size = n-k + 1;
//         int arr[] = new int[size];
//         for(int i=0;i<=n-k;i++){
//             int maxValue = nums[i];
//             for(int j=i;j<i+k;j++){
//                 maxValue = Math.max(maxValue,nums[j]);
//             }
//             arr[i]=maxValue;
//         }
//         return arr;
//     }
// }
//Optimal - T.C: O(N), S.C:O(1)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
         int [] ans = new int[n-k+1];
         Deque<Integer> deque = new ArrayDeque<>();
         for(int i=0;i<k;i++){
            while(deque.size()>0 && deque.getLast()<nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
         }
         ans[0] = deque.getFirst();
         for(int i=k;i<n;i++){
            if(nums[i-k]==deque.getFirst()) deque.removeFirst();
            while(deque.size()>0 && deque.getLast()<nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            ans[i-k+1] = deque.getFirst();
         }
         return ans;
    }
}
