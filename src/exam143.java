import java.util.HashSet;
import java.util.Set;

class Solution {

  public static int solution(int n, int[] lost, int[] reserve) {
    Set<Integer> reserveList = new HashSet<>();
    for (int i : reserve) {
      reserveList.add(i);
    }
    Set<Integer> lostList = new HashSet<>();
    for (int i : lost) {
      if (reserveList.contains(i)) {
        reserveList.remove(i);
      } else {
        lostList.add(i);
      }
    }

    for (Integer i : reserveList) {
      if (lostList.contains(i - 1)) {
        lostList.remove(i - 1);
      } else if (lostList.contains(i + 1)) {
        lostList.remove(i + 1);
      }
    }
    return n - lostList.size();
  }
}
