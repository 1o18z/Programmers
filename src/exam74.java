import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); // [0,1,3,5,6]
        
        for(int i=0; i<citations.length; i++){
            int h = citations.length-i; 
            
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}
