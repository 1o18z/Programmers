import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

class Solution {

  static Map<String, Integer> map
      = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);

  public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
    int conditionIndex = map.get(ext);
    int sortingCondition = map.get(sort_by);

    List<int[]> list = new ArrayList<>(Arrays.asList(data));

    return list.stream()
        .sorted(Comparator.comparingInt(o -> o[sortingCondition]))
        .filter(v -> v[conditionIndex] < val_ext)
        .toArray(int[][]::new);
  }
}
