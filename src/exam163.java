import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution {

  static class Person {

    int x, y;

    public Person(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  static int dx[] = {-1, 1, 0, 0};
  static int dy[] = {0, 0, -1, 1};

  static List<Integer> list;

  public static int[] solution(String[][] places) {
    list = new ArrayList<>();

    for (int k = 0; k < places.length; k++) {
      String[] values = places[k];
      boolean isPossible = true;

      for (int i = 0; i < places.length; i++) {
        for (int j = 0; j < places.length; j++) {
          if (values[i].charAt(j) == 'P') {
            if(!bfs(i, j, values)){
              isPossible = false;
            }
          }
        }
      }
      
      list.add(isPossible ? 1 : 0);
    }

    return list.stream().mapToInt(v -> v).toArray();
  }

  private static boolean bfs(int i, int j, String[] place) {
    Queue<Person> queue = new ArrayDeque<>();
    queue.offer(new Person(i, j));

    while (!queue.isEmpty()) {
      Person person = queue.poll();
      int px = person.x;
      int py = person.y;

      for (int k = 0; k < 4; k++) {
        int cx = px + dx[k];
        int cy = py + dy[k];

        if (cx < 0 || cy < 0 || cx >= 5 || cy >= 5 || (cx == i && cy == j)) {
          continue;
        }

        int distance = Math.abs(cx - i) + Math.abs(cy - j);

        if (place[cx].charAt(cy) == 'P' && distance <= 2) {
          return false;
        }
        if (place[cx].charAt(cy) == 'O' && distance < 2) {
          queue.offer(new Person(cx, cy));
        }
      }
    }

    return true;
  }

  /*public static void main(String[] args) {
    System.out.println(
        Arrays.toString(solution(new String[][]{
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        })));
  }*/
}
