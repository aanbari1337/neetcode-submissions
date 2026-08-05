class MinStack {
        private class Node {
        int value;
        int min;
        
        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
    Stack<Node> stack = new Stack<>();
    
    public MinStack() {
    
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Node(val, val));
        }else {
            int min = Math.min(val, stack.peek().min);
            stack.push(new Node(val, min));
        }
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
