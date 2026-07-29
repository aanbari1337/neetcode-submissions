class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();
        
        for (int i=0; i < strs.length; i++){
            var key = sort(strs[i]);
            map.computeIfAbsent(key, k -> new ArrayList()).add(strs[i]);
        }
        
        return new ArrayList(map.values());
        
    }

    private String sort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
