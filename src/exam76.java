import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int idx = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=B.length-1; i>=0; i--){
            answer += A[idx++]*B[i];
        }
        return answer;
    }
}
