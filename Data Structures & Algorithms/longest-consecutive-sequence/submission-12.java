class Solution {
    public int longestConsecutive(int[] nums) {

         int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        
        var count = 0;
        var longestSeq = 0;
        for (int i = 0; i < tmp.length; i++) {
            if(i + 1 < tmp.length && tmp[i] == tmp[i + 1]) continue;
            if(i + 1 < tmp.length &&
                    tmp[i] + 1 == tmp[i + 1]){
                count++;
            } else {
                longestSeq = Math.max(longestSeq, ++count);
                count = 0;
            }
        }
        return longestSeq;
    }
}
