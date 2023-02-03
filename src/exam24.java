package src;

public class exam24 {
  public String solution(String my_string) {
    String answer = my_string.replaceAll("[aeiou]", "");
    return answer;
  }
}
