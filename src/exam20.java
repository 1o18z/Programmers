package src;

public class exam20 {
  public String solution(String rsp) {
    String answer = "";
    String[] arr = rsp.split("");

    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals("0")) {
        answer += "5";
      } else if (arr[i].equals("2")) {
        answer += "0";
      } else
        answer += "2";
    }
    return answer;
  }
}

