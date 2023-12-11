import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

  public int[] solution(String msg) {
    Queue<String> queue = new LinkedList<>();

    for (String word : msg.split("")) {
      queue.offer(word);
    }

    List<String> list = IntStream.range('A', 'Z' + 1)
        .mapToObj(val -> String.valueOf((char)val))
        .collect(Collectors.toList());

    List<Integer> result = new ArrayList<>();

    String value = "";
    while (!queue.isEmpty() || !"".equals(value)) {
      if (list.contains(value + queue.peek())) {
        value = value + queue.poll();
        continue;
      }

      list.add(value + queue.peek());
      result.add(list.indexOf(value) + 1);
      value = "";
    }

    return result.stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
