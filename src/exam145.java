import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  static Map<String, Integer> map = new HashMap<>();
  static List<String> result = new ArrayList<>();

  public static String[] solution(String[] orders, int[] course) {

    for (int i = 0; i < orders.length; i++) {
      char[] chars = orders[i].toCharArray();
      Arrays.sort(chars);
      orders[i] = String.valueOf(chars);
    }
    
    for (int cour : course) {
      for (String order : orders) {
        dfs("", order, cour);
      }
      if (!map.isEmpty()) {
        List<Integer> list = new ArrayList<>(map.values());
        int max = Collections.max(list);

        if (max > 1) {
          for (String key : map.keySet()) {
            if (map.get(key) == max) {
              result.add(key);
            }
          }
        }
        map.clear();
      }
    }
    return result.stream().sorted().toArray(String[]::new);
  }

  private static void dfs(String order, String letter, int count) {
    if (count == 0) {
      map.put(order, map.getOrDefault(order, 0) + 1);
      return;
    }
    for (int i = 0; i < letter.length(); i++) {
      dfs(order + letter.charAt(i), letter.substring(i + 1), count - 1);
    }
  }
}
