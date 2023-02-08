import java.util.*;

public class exam38 {
  public String solution(String my_string) {
    String[] str = my_string.split("");
    String[] arr = Arrays.stream(str).distinct().toArray(String[]::new);
    String newStr = "";
    for (int i = 0; i < arr.length; i++) {
      newStr += arr[i];
    }
    return newStr;
  }
}

