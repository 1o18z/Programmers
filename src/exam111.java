import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int count=0;
        
        for(int scv : scoville){
            que.add(scv);
        }
        
        while(que.peek() < K){
            int first = que.poll();
            int second = que.poll();
            que.add(first + (second * 2));
            count++;
            
            if(que.size() == 1) return -1;
        }
        return count;
    }
}
