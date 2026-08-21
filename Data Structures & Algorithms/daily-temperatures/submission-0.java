class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int[] result = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++){

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                var previousIndex =  stack.pop();
                result[previousIndex] = i - previousIndex;
            }
            stack.push(i);
        }

        return result;

        
    }
}
