import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        String[] arr = s.split("");
        Deque<String> deque = new ArrayDeque<>();
        Stack<String> stack = new Stack<>();

        for (int k = 0; k < arr.length; k++) {
            deque.add(arr[k]);
        }

        for (int i = 0; i < s.length(); i++) {

            for (String value : deque) {
                if (value.equals("(") || value.equals("{") || value.equals("[")) {
                    stack.push(value);
                    continue;
                }
                if (!stack.isEmpty()) {
                    if (value.equals(")") && stack.peek().equals("(")) {
                        stack.pop();
                    }
                    if (value.equals("]") && stack.peek().equals("[")) {
                        stack.pop();
                    }
                    if (value.equals("}") && stack.peek().equals("{")) {
                        stack.pop();
                    }
                } else{
                    stack.push("a");
                    break;
                } 
                
            }

            if (stack.isEmpty()) {
                count++;
            }
            stack.clear();
            deque.addLast(deque.pollFirst()); // (){}[]
        }
        return count;
    }
}
