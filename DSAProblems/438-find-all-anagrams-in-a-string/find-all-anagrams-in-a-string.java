class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slength = s.length();
        int plength = p.length();
        List<Integer> result = new ArrayList<>();

        if(s.length()<p.length()){
            return result;
        }
        
        int[] patternFreq = new int[26];
        for(int i=0;i<plength;i++){
            patternFreq[p.charAt(i) - 'a']++;
        }

        int[] windowFreq = new int[26];
        for(int i=0;i<plength-1;i++){
            windowFreq[s.charAt(i) - 'a']++;
        }

        for(int i = plength - 1;i < slength;i++){
            windowFreq[s.charAt(i) - 'a']++;

            if(Arrays.equals(patternFreq,windowFreq)){
                result.add(i-plength+1);
            }
            windowFreq[s.charAt(i-plength+1) - 'a']--;
        }
        return result;
    }
}