class Solution {
    public boolean isPalindrome(String s) {
        String lowerS = s.toLowerCase();
        StringBuilder cleanS = new StringBuilder();

        for (char c : lowerS.toCharArray()){
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                cleanS.append(c);    
            };
            
        }

        int i = 0;
        int j = cleanS.length() - 1;
        while(i < j){
            if(cleanS.charAt(i) != cleanS.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
