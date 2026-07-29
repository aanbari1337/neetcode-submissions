class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap();

        for (var ch : s.toCharArray()){
           map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (var ch : t.toCharArray()){
            if(!map.containsKey(ch)) return false;
            else {
                var occurence = map.get(ch) - 1;
                if(occurence < 0) return false;
                map.put(ch, occurence);
            }
        }

        return true;
    }
}
