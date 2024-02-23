class Solution {

  public static int solution(int m, int n, int[][] puddles) {
    int[][] roads = new int[n + 1][m + 1];
    roads[1][1] = 1;
    for (int[] puddle : puddles) {
      roads[puddle[1]][puddle[0]] = -1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (roads[i][j] == -1) {
          continue;
        }
        if (roads[i - 1][j] > 0) {
          roads[i][j] += roads[i - 1][j] % 1000000007;
        }
        if (roads[i][j - 1] > 0) {
          roads[i][j] += roads[i][j - 1] % 1000000007;
        }
      }
    }
    return roads[n][m] % 1000000007;
  }
}
