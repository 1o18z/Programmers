import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = numbers.length - 1; i >= 0; i--) {
            while(!stack.isEmpty()){
                if(stack.peek() > numbers[i]){
                    result[i] = stack.peek();
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = -1;
            }
            stack.push(numbers[i]);
        }
        return result;
    }
}
