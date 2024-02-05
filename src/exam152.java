import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

  static final int[] dx = {0, 1, 0, -1};
  static final int[] dy = {1, 0, -1, 0};

  static boolean[][] visited;

  static class Position {

    int x;
    int y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int[] solution(int m, int n, int[][] picture) {
    visited = new boolean[m][n];

    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (picture[i][j] != 0 && !visited[i][j]) {
          numberOfArea++;
          maxSizeOfOneArea = Math.max(bfs(i, j, picture), maxSizeOfOneArea);
        }
      }
    }

    int[] result = new int[2];
    result[0] = numberOfArea;
    result[1] = maxSizeOfOneArea;

    return result;
  }

  private static int bfs(int x, int y, int[][] picture) {
    Queue<Position> queue = new ArrayDeque<>();
    queue.add(new Position(x, y));

    visited[x][y] = true;
    int count = 1;

    while (!queue.isEmpty()) {
      Position position = queue.poll();
      int px = position.x;
      int py = position.y;

      for (int i = 0; i < 4; i++) {
        int cx = px + dx[i];
        int cy = py + dy[i];

        if (cx >= 0 && cx < picture.length && cy >= 0 && cy < picture[0].length) {
          if (picture[cx][cy] == picture[px][py] && !visited[cx][cy]) {
            queue.add(new Position(cx, cy));
            visited[cx][cy] = true;
            count++;
          }
        }
      }
    }

    return count;
  }
}
