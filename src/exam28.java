public class exam28 {
  public int solution(int num, int k) {
    String numm = Integer.toString(num);
    String kk = Integer.toString(k);
    if (numm.indexOf(kk) == -1) {
      return -1;
    } else {
      return numm.indexOf(kk) + 1;
    }
  }
}

