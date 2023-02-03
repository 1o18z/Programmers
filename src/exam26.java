import java.util.Arrays;

public class exam26 {
  public String solution(String my_string) {
    String answer = "";
    char[] str = my_string.toLowerCase().toCharArray();
    Arrays.sort(str);
    answer = new String(str);
    return answer;
  }
}

