class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int leftSum = 0;
            int rightSum = 0;
            for(int j=0;j<i;j++){
                leftSum += nums[j];
            }
            for(int j=i+1;j<n;j++){
                rightSum += nums[j];
            }
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
}
// class Solution {
//     public int pivotIndex(int[] nums) {
//         int n = nums.length;
//         int totalSum = 0;
//         for(int i=0;i<n;i++){
//             totalSum += nums[i];
//         }
//         int currSum = 0;
//         for(int i=0;i<n;i++){
//             if(currSum == totalSum - currSum - nums[i]){
//                 return i;
//             }
//             currSum+=nums[i];
//         }
//         return -1;
//     }
// }