import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer[]> stack = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            result[i] = result.length -1 -i;
            Integer[] arr = {i, prices[i]};
            
            while(!stack.empty() && stack.peek()[1] > prices[i]){
                Integer[] price = stack.pop();
                result[price[0]] = i - price[0];
            }
            stack.push(arr);
            }
        return result;
    }
}
