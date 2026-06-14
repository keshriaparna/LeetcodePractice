class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid]>=nums[low]){
              if(ans == -1 || nums[low]<ans){
                ans = nums[low];
              }
              low = mid + 1;
            }
            else {
              if(ans == -1 || nums[mid]<ans){
                ans = nums[mid];
              }
              high = mid - 1;
            }
        }
        return ans;
    }
}