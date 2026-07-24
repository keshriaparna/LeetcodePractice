class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = 0; i < n ; i++){
            int currEle = nums[i];
            for(int j = 0; j < n; j++){
                int ind = (i+j) % n;
                if(nums[ind] > currEle){
                    ans[i] = nums[ind];
                    break;
                }
            }
        }
        return ans;
    }
}