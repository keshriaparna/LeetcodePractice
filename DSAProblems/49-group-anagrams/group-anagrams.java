// Brute Force - T.C: O(n*mlogm), S.C: O(n*m)
//class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         HashMap<String,List<String>> groups = new HashMap<>();
//         for(String word: strs){
//             char[] sortedWord = word.toCharArray();
//             Arrays.sort(sortedWord);
//             String key = new String(sortedWord);

//             groups.putIfAbsent(key, new ArrayList<>());
//             groups.get(key).add(word);
//         }
//         List<List<String>> result = new ArrayList<>();
//         for(List<String> group : groups.values()){
//             result.add(group);
//         }
//         return result;
//     }
// }
// Optimal - T.C: O(n*m), S.C: O(n*m)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> groups = new HashMap<>();
        for(String word : strs){
            int[] freq = new int[26];
            for(char c : word.toCharArray()){
                freq[c-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int count : freq){
                key.append('#').append(count);
            }
            groups.putIfAbsent(key.toString(),new ArrayList<>());
            groups.get(key.toString()).add(word);
        }
        return new ArrayList<>(groups.values());
    }
}
