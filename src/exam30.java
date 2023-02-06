import java.util.Arrays;

public class exam30 {

  public int[] solution(String my_string) {
    return Arrays.stream(my_string.split(""))
            .filter(i -> i.matches("[0-9]"))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
  }
}
