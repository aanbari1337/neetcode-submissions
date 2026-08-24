class Solution {
    public boolean isPalindrome(String s) {
         String lowerS = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int i = 0;
        int j = lowerS.length() - 1;
        while(i < j){
            if(lowerS.charAt(i) != lowerS.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
