package src;

public class exam21 {
  public int solution(String my_string) {
    int answer = 0;
    String mst = my_string.toLowerCase().replaceAll("[abcdefghijklmnopqrstudvwxyz]", "");
    String[] arr = mst.split("");
    for (int i = 0; i < arr.length; i++) {
      answer += Integer.parseInt(arr[i]);
    }
    return answer;
  }
}