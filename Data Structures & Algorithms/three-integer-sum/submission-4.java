class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList();
        Set<String> seenTriplets = new HashSet<>();

        for (int i=0;i < nums.length;i++){
            int left = i +1;
            int right = nums.length - 1;

            while (left < right){
                int sum = nums[left] + nums[right];
                String key = "" + nums[i] + nums[left] + nums[right];
                if(nums[i] + sum == 0 && !seenTriplets.contains(key)){
                    triplets.add(List.of(nums[i],nums[left],nums[right]));
                    seenTriplets.add(key);
                }
                else if (sum + nums[i] > 0) right--;
                else left++;

                if(left == right) break;
            }
        }

        return triplets;
    }
}
