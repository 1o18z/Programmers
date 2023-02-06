import java.util.Arrays;

public class exam30 {

  public int[] solution(String my_string) {
    return Arrays.stream(my_string.split(""))
                        // 받은 문자열을 한 글자씩 나누고
            .filter(i -> i.matches("[0-9]"))
                // 나눈 문자열 중 0~9인 문자만 남기고
            .mapToInt(Integer::parseInt)
                // integer로 변환 후
            .sorted()
                // 정렬하고
            .toArray();
                // 배열로 변환
  }
}
