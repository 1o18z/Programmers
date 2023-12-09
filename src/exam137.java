import java.util.ArrayDeque;

import java.util.Queue;

class Solution {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static boolean[][] visited;

  static class Position {

    int y;
    int x;

    public Position(int y, int x) {
      this.y = y;
      this.x = x;
    }

    public int getY() {
      return y;
    }

    public int getX() {
      return x;
    }
  }

  public int solution(int[][] land) {
    int maxOil = 0;

    for (int i = 0; i < land[0].length; i++) {
      boolean[][] visited = new boolean[land.length][land[0].length];
      int amount = 0;

      for (int j = 0; j < land.length; j++) {
        if (land[j][i] == 1 && !visited[j][i]) {
          amount += bfs(j, i, land, visited);
        }
      }
      maxOil = Math.max(maxOil, amount);
    }
    return maxOil;
  }

  public int bfs(int y, int x, int[][] land, boolean[][] visited) {
    Queue<Position> queue = new ArrayDeque<>();
    int count = 0;
    queue.offer(new Position(y, x));
    visited[y][x] = true;

    while (!queue.isEmpty()) {
      Position position = queue.poll();
      int positionY = position.getY();
      int positionX = position.getX();
      count++;

      for (int i = 0; i < 4; i++) {
        int currentY = positionY + dy[i];
        int currentX = positionX + dx[i];

        if (currentX >= 0 && currentY >= 0 && currentY < land.length && currentX < land[0].length) {
          if (!visited[currentY][currentX] && land[currentY][currentX] == 1) {
            queue.offer(new Position(currentY, currentX));
            visited[currentY][currentX] = true;
          }
        }
      }
    }
    return count;
  }
}
