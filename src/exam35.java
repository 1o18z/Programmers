import java.util.ArrayList;
public class exam35 {
  public int[] solution(int n, int[] numlist) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < numlist.length; i++) {
      if (numlist[i] % n == 0) {
        arr.add(numlist[i]);
      }
    }
    int[] answer = arr.stream().mapToInt(Integer::intValue).toArray();
    return answer;
  }
}

