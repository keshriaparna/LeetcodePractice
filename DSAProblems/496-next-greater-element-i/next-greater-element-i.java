class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int val = -1;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                   for(int k=j+1;k<nums2.length;k++){
                    if(nums2[k]>nums1[i]){
                        val = nums2[k];
                        break;
                    }
                   } 
                   ans[i] = val;
                   break;
                }
            }
        }
        return ans;
    }
}
// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         Stack<Integer> st = new Stack<>();
//         st.push(-1);
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i= nums2.length - 1; i >= 0; i--){
//             while(st.peek() != -1 && st.peek() <= nums2[i]){
//                 st.pop();
//             }
//             map.put(nums2[i],st.peek());
//             st.push(nums2[i]);
//         }
//         int[] result = new int[nums1.length];
//         for(int i = 0;i < result.length; i++){
//             result[i] = map.get(nums1[i]);
//         }
//         return result;
//     }
// }