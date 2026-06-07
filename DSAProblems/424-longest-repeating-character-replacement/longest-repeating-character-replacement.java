class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int maxLen = 0;
        int[] freqChar = new int[26];
        while(r<s.length()){
            freqChar[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq,freqChar[s.charAt(r) - 'A']);
            while((r-l+1) - maxFreq > k){
                freqChar[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen,r - l + 1);
            r++;
        }
        return maxLen;
    }
}