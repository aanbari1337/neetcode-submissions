class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (var t : tokens){
            switch (t) {
                case "+" -> stack.add(stack.pop() + stack.pop());
                case "-" -> {
                    var right = stack.pop();
                    var left = stack.pop();
                    stack.add(left - right);
                }
                case "*" -> stack.add(stack.pop() * stack.pop());
                case "/" -> {
                    var right = stack.pop();
                    var left = stack.pop();
                    stack.add(left / right);
                }
                default -> stack.add(Integer.valueOf(t));
            }

        }

        return stack.pop();
    }
}
