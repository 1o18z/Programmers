import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        int sum = 0;
        Arrays.sort(score);
        
        for(int i=score.length-1; i>=0; i--){
            if((score.length-i) % m == 0){
                sum += score[i] * m;
            }
        }
        return sum;
    }
}
