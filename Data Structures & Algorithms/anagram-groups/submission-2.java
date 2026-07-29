class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashSet<String> seen = new HashSet();
        
        for (int i=0; i < strs.length; i++){
            List<String> group = new ArrayList();
            var key = sort(strs[i]);

            if(seen.contains(key)) continue;
            else {
                group.add(strs[i]);
                seen.add(sort(key));
            };
            
            
            for(int j= i + 1; j < strs.length; j++){
                if(isAnagram(strs[i], strs[j]))
                    group.add(strs[j]);
            }
            list.add(group);
        }
        
        return list;
        
    }

    private String sort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        
        return new String(chars);
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap();
        
        for (var ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for (var ch : t.toCharArray()){
            if(!map.containsKey(ch)) return false;
            else {
                var occurrence = map.get(ch) - 1;
                if(occurrence < 0) return false;
                map.put(ch, occurrence);
            }
        }
        
        return true;
    }
}
