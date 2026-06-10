class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i=0;i<n-m+1;i++){
            int temp = i;
            int j=0;
            for(j=0;j<m;j++){
                if(haystack.charAt(temp)!= needle.charAt(j)){
                    break;
                }
                temp++;
            }
            if(j == m){
            return i;
            }
        }
        return -1;
    }
}