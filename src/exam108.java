import java.util.Arrays;
class Solution {
    public int solution(int[] A, int[] B) {
        int count = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++){
            if(A[count] >= B[i]){
                continue;
            }
            count++;
        }
        return count;
    }
}
