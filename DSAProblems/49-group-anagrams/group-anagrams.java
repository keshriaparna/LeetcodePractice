class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> groups = new HashMap<>();
        for(String word: strs){
            char[] sortedWord = word.toCharArray();
            Arrays.sort(sortedWord);
            String key = new String(sortedWord);

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> group : groups.values()){
            result.add(group);
        }
        return result;
    }
}