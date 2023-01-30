import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2+1);
                                                // 마지막 요소 다음 인덱스라 인덱스 3의 요소까지 출력됨!
    }
}