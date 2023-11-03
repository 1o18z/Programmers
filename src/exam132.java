import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        int result = 0;
        
        for(int i=0; i<queue1.length; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            que1.add(queue1[i]);
            que2.add(queue2[i]);
        }
        
        while(sum1 != sum2){
            if(result > (queue1.length + queue2.length) * 2) return -1;
            if(sum1 < sum2){
                int popNum = que2.poll();  
                que1.add(popNum);    
                sum1 += (long) popNum;
                sum2 -= (long)popNum;
            } else if(sum1 > sum2){
                int popNum = que1.poll();  
                que2.add(popNum);    
                sum1 -= (long)popNum;
                sum2 += (long)popNum;
            }
            result++;
            
        }
        return result;
    }
}
