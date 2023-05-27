import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] result = new int[2];
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(String op : operations){
            String[] str = op.split(" ");
            
            if(str[0].equals("I")){
                minQue.offer(Integer.valueOf(str[1]));
                maxQue.offer(Integer.valueOf(str[1]));
            } 
            if(str[0].equals("D")){
                if(str[1].equals("-1")){
                        maxQue.remove(minQue.poll());
                }
                if(str[1].equals("1") && !maxQue.isEmpty()){
                        minQue.remove(maxQue.poll());
                }
            }
        }
        if(!maxQue.isEmpty() && !minQue.isEmpty()){
            result[0] = maxQue.peek();
            result[1] = minQue.peek();
        }
        return result;
    }
}
