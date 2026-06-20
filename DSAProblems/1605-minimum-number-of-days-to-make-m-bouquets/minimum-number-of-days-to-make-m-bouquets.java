class Solution {
    private boolean possible(int nums[],int day,int m,int k){
        int n = nums.length;
        int count = 0;
        int noOfB = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] <= day){
                count++;
            }
            else{
                noOfB += (count/k);
                count = 0;
            }
        }
        noOfB += (count/k);
        return noOfB >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
     int n = bloomDay.length;
     long val = (long) m * k;
     if(val > n) return -1;
     int min = Integer.MAX_VALUE;
     int max = Integer.MIN_VALUE;
     int ans = -1;
     for(int i=0;i<n;i++){
        min = Math.min(min, bloomDay[i]);
        max = Math.max(max, bloomDay[i]);
     }
     int low = min;
     int high = max;
     while(low<=high){
        int mid = low + (high - low)/2;
        if(possible(bloomDay,mid,m,k)){
            ans = mid;
            high = mid - 1;
        }
        else{
            low = mid + 1;
        }
     }
     return ans;
    }
}