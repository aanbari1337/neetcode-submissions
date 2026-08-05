class Solution {
    public int longestConsecutive(int[] nums) {
        
       Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        int[] sortedArray = set.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
        
        var count = 0;
        var longestSeq = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if(i + 1 < sortedArray.length &&
                    sortedArray[i] + 1 == sortedArray[i + 1]){
                count++;
            }else {
                count++;
                if(count > longestSeq){
                    longestSeq = count;
                }
                count = 0;
            }
        }
        return longestSeq;
    }
}
