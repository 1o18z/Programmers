package src;

public class exam16 {
  public int solution(String[] s1, String[] s2) {
    int result = 0;
    for (int i = 0; i < s2.length; i++) {
      for (int j = 0; j < s1.length; j++) {
        if (s1[j].equals(s2[i])) {
          result++;
        }
      }
    }
    return result;
  }
}

