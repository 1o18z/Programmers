import java.util.*;

public class exam32 {
  public int solution(int[] array) {
    int answer = 0;
    for (int i = 0; i < array.length; i++) {
      String str = Integer.toString(array[i]);
      String[] arr = str.split("");

      for (int j = 0; j < arr.length; j++) {
        if (arr[j].equals("7")) {
          answer++;
        }
      }
    }
    return answer;
  }
}

