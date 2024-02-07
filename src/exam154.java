import java.util.HashMap;
import java.util.Map;

class Solution {

  public int solution(String[][] clothes) {
    Map<String, Integer> map = new HashMap<>();
    for (String[] clothe : clothes) {
      map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
    }

    int result = 1;
    for (Integer value : map.values()) {
      result *= value + 1;
    }

    return result - 1;
  }
}
