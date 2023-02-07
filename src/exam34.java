import java.util.Arrays;

public class exam34 {
  public int[] solution(int[] array) {
    int[] answer = Arrays.copyOfRange(array, 0, array.length);
    Arrays.sort(answer);
    int max = answer[answer.length - 1];

    int[] result = new int[2];
    result[0] = max;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == max) {
        result[1] = i;
      }
    }
    return result;
  }
}

