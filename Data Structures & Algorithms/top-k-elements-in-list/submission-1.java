class Solution {
   public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                Map.Entry.<Integer, Integer>comparingByValue().reversed()
        );
        
        for (var e : map.entrySet()){
            maxHeap.add(Map.entry(e.getKey(), e.getValue()));
        }
        
        var topK = new int[k];
        for (int i = 0; i < k; i++){
            topK[i] = maxHeap.poll().getKey();
        }
        
        return topK;
    }
}
