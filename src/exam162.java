public class Solution {

  static int[][] board;
  static int[] result;

  static int[] solution(int rows, int columns, int[][] queries) {
    board = new int[rows + 1][columns + 1];
    result = new int[queries.length];

    int count = 1;
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= columns; j++) {
        board[i][j] = count++;
      }
    }

    int index = 0;
    while (index < queries.length) {
      rotate(index++,  queries);
    }

    return result;
  }

  private static void rotate(int index, int[][] queries) {
    int[] query = queries[index];
    int temp = board[query[0]][query[1]];

    int min = Integer.MAX_VALUE;
    min = Math.min(temp, min);

    for (int i = query[0]; i < query[2]; i++) {
      int value = board[i + 1][query[1]];
      min = Math.min(min, value);
      board[i][query[1]] = value;
    }
    for (int i = query[1]; i < query[3]; i++) {
      int value = board[query[2]][i + 1];
      min = Math.min(min, value);
      board[query[2]][i] = value;
    }
    for (int i = query[2]; i > query[0]; i--) {
      int value = board[i - 1][query[3]];
      min = Math.min(min, value);
      board[i][query[3]] = value;
    }
    for (int i = query[3]; i > query[1] + 1; i--) {
      int value = board[query[0]][i - 1];
      min = Math.min(min, value);
      board[query[0]][i] = value;
    }
    board[query[0]][query[1] + 1] = temp;
    result[index] = min;
  }
}
