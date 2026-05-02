//Brute Force - Nested Loop, T.C: O(N^2), S.C: O(1) 
// class Solution {
//     public int maxArea(int[] height) {
//         int max = Integer.MIN_VALUE;
//         for(int i=0;i<height.length;i++){
//             for(int j=i+1;j<height.length;j++){
//                 int area = (j-i) * Math.min(height[i],height[j]);
//                 max = Math.max(max, area);
//             }
//         }
//         return max;
//     }
// }
//Optimal - Two Pointers, T.C: O(N), S.C:O(1)
class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while(i<j){
           int area = (j-i) * Math.min(height[i],height[j]);
           max = Math.max(max, area);
           if(height[i]<height[j]){
            i++;
           } 
           else{
            j--;
           }
        }
        return max;
    }
}