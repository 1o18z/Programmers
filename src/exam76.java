import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Integer[] newB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(newB, Comparator.reverseOrder());
        for(int i=0; i<A.length; i++){
            answer += A[i]*newB[i];
        }
        return answer;
    }
}
// 정확성은 통과인데 효율성 테스트 실패 ㅠㅠ
