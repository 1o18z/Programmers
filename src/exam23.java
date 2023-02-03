package src;

public class exam23 {
  public int solution(int n) {
    int answer = 0;
    for (int i = 1; i <= n; ) {
      if (i * i != n) {
        i++;
      } else {
        return 1;
      }
    }
    return 2;
  }
}

