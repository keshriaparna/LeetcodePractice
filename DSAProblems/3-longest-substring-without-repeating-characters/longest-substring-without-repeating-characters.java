class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0; // initialized as zero because string can be empty in that case length will be zero so it will return maxLength as zero.
        for(int i=0;i<n;i++){
            int[] hash = new int[256];
            Arrays.fill(hash,0);
            for(int j=i;j<n;j++){
                if(hash[s.charAt(j)] == 1) break;
                hash[s.charAt(j)] = 1;
                int len = j-i+1;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}