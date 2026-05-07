class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int actual_sum = 0;
        int unique_sum = 0;
        int expected_sum = n*(n+1)/2;
        Set<Integer> uniqueSet = new HashSet<>();
        for(int num: nums){
            if(uniqueSet.add(num)){
                unique_sum += num;
            }
            actual_sum += num;
        }
        int duplicate = actual_sum - unique_sum;
        int missing = expected_sum - unique_sum;

        return new int[] {duplicate, missing};
    }
}