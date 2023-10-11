import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        int[] box = new int[order.length];
        for(int i=0; i<order.length; i++){
            box[order[i]-1] = i;
        }
        
        Stack<Integer> stack = new Stack<>();
        int target = 0;
        for(int i=0; i<order.length; i++){
            if(box[i] == target) {
                target++;
            } else {
                stack.push(box[i]);
            }
            while(!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                target++;
            }
        }
        return target;
    }
}
