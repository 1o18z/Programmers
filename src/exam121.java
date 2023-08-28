import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        int xLength = maps.length;
        int yLength = maps[0].length;
        isVisited = new boolean[xLength][yLength];
      
        return bfs(0, 0, xLength, yLength, maps, isVisited);
    }

    static int bfs(int x, int y, int xLength, int yLength, int[][] maps, boolean[][] isVisited) {

        class Position {
            int moveX;
            int moveY;
            int count;

            public Position(int moveX, int moveY, int count) {
                this.moveX = moveX;
                this.moveY = moveY;
                this.count = count;
            }
        }

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y, 1));
        isVisited[x][y] = true;
        maps[x][y] = 0;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            int result = position.count;
            int positionX = position.moveX;
            int positionY = position.moveY;

            if (positionX == xLength - 1 && positionY == yLength - 1) {
                return result;
            }

            for (int i = 0; i < 4; i++) {
                int currentX = positionX + dx[i];
                int currentY = positionY + dy[i];

                if (currentX >= 0 && currentX < xLength && currentY >= 0 && currentY < yLength) {
                    if (maps[currentX][currentY] == 1 && !isVisited[currentX][currentY]) {
                        queue.offer(new Position(currentX, currentY, result + 1));
                        isVisited[currentX][currentY] = true;
                    }
                }
                maps[positionX][positionY] = 0;
            }
        }
        return -1;
    }
  
}
