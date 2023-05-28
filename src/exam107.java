import java.util.PriorityQueue;
import java.util.Collections;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        
        for(int work : works){
            queue.offer(work);
        }

        for(int i=0; i<n; i++){
            int qu = queue.poll();
            if(qu == 0) break;
            queue.offer(qu-1);
        }
      
        for(int que : queue){
            sum += que*que;
        }
        return sum;
    }
}
