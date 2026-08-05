class Solution {
    public boolean isValid(String s) {
    if(s == null){
            return false;
        }
        Stack<Character> stack = new Stack();
        Map map = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );
        
        Collection openBrackets = map.values();
        for (var c : s.toCharArray()){
            if(openBrackets.contains(c)) stack.add(c);
            else if (!stack.isEmpty() && stack.peek().equals(map.get(c))) stack.pop();
            else return false;
        }
        
        return stack.isEmpty();
    }
}
