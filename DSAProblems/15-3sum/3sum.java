//Brute - T.C: O(N^3*log(no. of triplets)), S.C:O(2 * no. of unique triplets)
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         HashSet<List<Integer>> set = new HashSet<>();
//        for(int i=0;i<nums.length-2;i++){
//         for(int j=i+1;i<nums.length-1;j++){
//             for(int k=j+1;k<nums.length;k++){
//                 if(nums[i]+nums[j]+nums[k]==0){
//                     List<Integer> temp = new ArrayList<>();
//                     temp.add(nums[i]);
//                     temp.add(nums[j]);
//                     temp.add(nums[k]);

//                     Collections.sort(temp);
//                     set.add(temp);
//                 }
//             }
//         }
//        } 
//        List<List<Integer>> ans = new ArrayList<>(set);
//        return ans;
//     }
// }
// Better - T.C: O(N^2)*log(no. of unique triplets),S.C:O(log(2 * no. of unique triplets))+O(N)
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         HashSet<List<Integer>> set = new HashSet<>();
//         for(int i=0;i<nums.length;i++){
//             HashSet<Integer> hashSet = new HashSet<>();
//             for(int j=i+1;j<nums.length;j++){
//                 int third = -(nums[i]+nums[j]);
//                 if(hashSet.contains(third)){
//                     List<Integer> temp = new ArrayList<Integer>();
//                     temp.add(nums[i]);
//                     temp.add(nums[j]);
//                     temp.add(third);
//                     Collections.sort(temp);
//                     set.add(temp);
//                 }
//                 hashSet.add(nums[j]);
//             }
//         }
//         List<List<Integer>> ans = new ArrayList<>(set);
//         return ans;
//     }
// }
//Optimal - T.C:O(NlogN)+O(N^2),,S.C:O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
            if(sum < 0){
                j++;
            }
            else if(sum>0) {
                k--;
            }
            else{ 
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                ans.add(list);

                j++;
                k--;
                while(j<k && nums[j] == nums[j-1]) j++;
                while(j<k && nums[k] == nums[k+1]) k--;
            }
          }
        }
        return ans;
    }
}