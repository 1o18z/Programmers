class exam44 {
  public String solution(String phone_number) {
    String[] ph = phone_number.split("");
    String answer = "";
    for (int i = 0; i < ph.length; i++) {
      if (i < ph.length - 4) {
        answer += "*";
      } else {
        answer += ph[i];
      }
    }
    return answer;
  }
}