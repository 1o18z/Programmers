import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            queue.offer(0);
        }
        
        int idx = 0;
        int current = 0;
        while(idx < truck_weights.length){
            current -= queue.poll();
            result++;
            if(current + truck_weights[idx] <= weight){
                queue.offer(truck_weights[idx]);
                current += truck_weights[idx++];
            } else{
                queue.offer(0);
            }
        }
        return result + bridge_length;
    }
}
