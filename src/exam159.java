import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {

  static ArrayList<Integer>[] list;

  public static int solution(int n, int[][] wires) {
    list = new ArrayList[n + 1];
    int result = Integer.MAX_VALUE;

    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }
    for (int[] wire : wires) {
      list[wire[0]].add(wire[1]);
      list[wire[1]].add(wire[0]);
    }

    for (int[] wire : wires) {
      int c1 = play(wire[0], wire[1], new boolean[n + 1]);
      int c2 = play(wire[1], wire[0], new boolean[n + 1]);

      result = Math.min(result, Math.abs(c1 - c2));
    }

    return result;
  }

  private static int play(int v1, int v2, boolean[] visited) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(v1);
    int count = 0;
    visited[v1] = true;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      count += 1;

      for (int value : list[current]) {
        if (!visited[value] && value != v2) {
          visited[value] = true;
          queue.add(value);
        }
      }
    }
    return count;
  }
}
