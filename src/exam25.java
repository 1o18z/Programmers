package src;

public class exam25 {
  public String solution(String my_string) {
    String answer = "";
    String[] mst = my_string.split("");
    for (int i = 0; i < mst.length; i++) {
      if (mst[i].equals(mst[i].toUpperCase())) {
        answer += mst[i].toLowerCase();
      } else {
        answer += mst[i].toUpperCase();
      }
    }
    return answer;
  }
}

