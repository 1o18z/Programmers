public class exam29 {
  public int solution(int[] box, int n) {
    int a = box[0];
    int b = box[1];
    int c = box[2];
    int answer = (a / n) * (b / n) * (c / n);
    return answer;
  }
}
