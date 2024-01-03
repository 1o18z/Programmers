class Solution {

  static int[] dh = {0, 1, -1, 0};
  static int[] dw = {1, 0, 0, -1};

  public int solution(String[][] board, int h, int w) {
    int count = 0;
    String currentColor = board[h][w];

    for (int i = 0; i < 4; i++) {
      int positionY = h + dh[i];
      int positionX = w + dw[i];

      if (positionX >= 0 && positionY >= 0 && positionX < board[0].length
          && positionY < board.length) {
        if (board[positionY][positionX].equals(currentColor)) {
          count++;
        }
      }
    }
    return count;
  }
}
