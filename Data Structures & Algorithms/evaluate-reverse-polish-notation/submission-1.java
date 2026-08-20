class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>(List.of("+", "-", "*", "/"));

        for (var t : tokens){
            if(!operators.contains(t))
                stack.add(Integer.valueOf(t));

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
            }

        }

        return stack.pop();
    }
}
