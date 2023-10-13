import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long min = 1;
        long max = times[times.length-1] * n; 
        long mid = 0;
        long result = max;
        
        while(min <= max){
            mid = (min + max) / 2;
            int number = 0;
            
            for(int time: times){
                number += mid / time;
            }
            
            if(number < n){
                min = mid+1;
            } else{
                max = mid-1;  
                result = mid;
            }
        }
        
      return result;        
    }
}
