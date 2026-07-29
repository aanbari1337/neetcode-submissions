class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (var str : strs) {
            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }

        return encoded.toString();
    }

   public List<String> decode(String str) {

        List<String> strs = new ArrayList();
        var start = 0;
        var i = 0;
        while (i < str.length()) {
            var ch = str.charAt(i);
            // 5#hello4#world
            // s      i
            if (ch == '#') {
                int size = Integer.parseInt(str.substring(start, i));
                strs.add(str.substring(i + 1, i + size + 1));
                i = i + size + 1;
                start = i;
            }else i++;
        }

        return strs;
    }
}
