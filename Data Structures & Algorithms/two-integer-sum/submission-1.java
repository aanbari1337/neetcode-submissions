class Solution {
    public int[] twoSum(int[] nums, int target) {
        // i + j = target;
        // j = target - i; 
        HashMap<Integer, Integer> map = new HashMap<>();

        for (var i = 0; i < nums.length; i++) map.put(nums[i], i);

        for (var i = 0; i < nums.length; i++){
            var j = target - nums[i];
            if(map.containsKey(j) && i != map.get(j)){
                return new int[]{i, map.get(j)};
            }
        }

        return new int[]{};
    }
}
