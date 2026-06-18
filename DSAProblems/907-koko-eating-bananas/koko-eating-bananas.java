class Solution {
    private int findMax(int arr[]){
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxValue = Math.max(arr[i],maxValue);
        }
        return maxValue;
    }
    private int calculateTotalHours(int[] arr, int hourly){
        int totalHour = 0;
        for(int i=0;i<arr.length;i++){
            totalHour += Math.ceil((double) arr[i]/(double) hourly);
        }
        return totalHour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);
        while(low<=high){
            int mid = low + (high - low)/2;
            int totalHour = calculateTotalHours(piles, mid);
            if(totalHour <= h){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}