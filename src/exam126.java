import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};

    public int[] solution(String[] maps) {
        String[][] arr = new String[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                arr[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!arr[i][j].equals("X")) {
                    list.add(dfs(i, j, arr, arr.length, arr[0].length));
                }
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        Collections.sort(list);
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int dfs(int x, int y, String[][] arr, int n, int m) {
        int count = Integer.parseInt(arr[x][y]);
        arr[x][y] = "X";

        for (int i = 0; i < 4; i++) {
            int currentX = x + moveX[i];
            int currentY = y + moveY[i];

            if (currentX >= 0 && currentX < n && currentY >= 0 && currentY < m) {
                if (!arr[currentX][currentY].equals("X")) {
                    count += dfs(currentX, currentY, arr, n, m);
                }
            }
        }
        return count;
    }
}
