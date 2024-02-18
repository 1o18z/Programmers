import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

  static boolean[] visited;
  static int index;

  public static int solution(int[] cards) {
    List<Integer> list = new ArrayList<>();
    visited = new boolean[cards.length + 1];

    for (int i = 0; i < cards.length; i++) {
      if (!visited[i + 1]) {
        index = 1;
        visited[i + 1] = true;
        play(cards[i], cards);
        list.add(index);
      }
    }

    if (list.size() < 2) {
      return 0;
    }

    list.sort(Collections.reverseOrder());
    return list.get(0) * list.get(1);
  }

  private static void play(int i, int[] cards) {
    if (!visited[i]) {
      visited[i] = true;
      index += 1;
      play(cards[i - 1], cards);
    }
  }
}
