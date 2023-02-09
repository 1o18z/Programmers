import java.util.*;

public class exam39 {
  public int[] solution(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    int[] arr = new int[10];
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        list.add(i);
      }
    }
    return list.stream().mapToInt(i -> i).sorted().toArray();
  }
}

