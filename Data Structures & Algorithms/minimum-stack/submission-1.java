class MinStack {
    int[] items;
    int size = 0;
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
    
    }
    
    public void push(int val) {
        if(items == null){
            items = new int[]{val};
        }else{
            items = Arrays.copyOf(items, items.length + 1);
            items[size] = val;
        }
        size++;
        min = Math.min(val, min);
    }
    
    public void pop() {
        size--;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            min = Math.min(min, items[i]);
        }
    }
    
    public int top() {
        return items[size - 1];
    }
    
    public int getMin() {
        return min;
    }
}
