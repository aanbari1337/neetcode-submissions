class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        var entries=  map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .toList();
                
        var topK = new int[k];
        for (int i = 0; i < k; i++){
            topK[i] = entries.get(i).getKey();
        }
        
        return topK;
    }
}
