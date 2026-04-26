//Brute Force - TC- O(N^3), SC- O(1) - Calculating product of each subarray and then finding the max out it
//Better Approach TC- O(N^2), SC- O(1) - As each subarray product is having an extra multiplication of one element then previous product, so we are calculating prefix product and comparing the max and the current product at each index.
// class Solution {
//     public int maxProduct(int[] nums) {
//         int max = Integer.MIN_VALUE;
//         for(int i=0;i<nums.length;i++){
//             int prod = 1;
//             for(int j=i;j<nums.length;j++){
//                 prod = prod * nums[j];
//                 max = Math.max(max,prod);
//             }
//         }
//         return max;
//     }
// }
//Optimal Approach TC- O(N), SC- O(1) - 1)Observations - Max product can be product of all the elements present in the array if all of them are positive nos or even number of negative nos exist in the array, Product of odd number of negative elements can result in negative product.
//If an array element is zero, considering it in the subarray will result in product as 0, so just reset the prefix product or suffix product to 1 if you encounter any zero.\
// use one for loop to iterate and calculate the prefix and suffix product and at each index compute the max product using prefix and suffix product.
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        for(int i=0;i<n;i++){
            if(prefix == 0) prefix =1;
            if(suffix == 0) suffix =1;
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            ans = Math.max(ans,Math.max(prefix,suffix));
        }
        return ans;
    }
}