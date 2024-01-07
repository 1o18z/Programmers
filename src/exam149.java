import java.util.ArrayList;
import java.util.List;

class Solution {

  public static int solution(String dartResult) {
    List<Integer> list = new ArrayList<>();
    int result = 0;
    int score = 0;
    int index = 0;

    for (int i = 0; i < dartResult.length(); i++) {
      char c = dartResult.charAt(i);

      if (c == '1' && dartResult.charAt(i + 1) == '0') {
        score = 10;
        i++;
      } else if (c >= '0' && c <= '9') {
        score = c - 48;
      } else if (c == 'S') {
        list.add(score);
        index++;
      } else if (c == 'D') {
        list.add((int) Math.pow(score, 2));
        index++;
      } else if (c == 'T') {
        list.add((int) Math.pow(score, 3));
        index++;
      } else if (c == '*') {
        if (index > 1) {
          list.set(index - 2, list.get(index - 2) * 2);
        }
        list.set(index - 1, list.get(index - 1) * 2);
      } else if (c == '#') {
        list.set(index - 1, -list.get(index - 1));
      }
    }

    for (int value : list) {
      result += value;
    }

    return result;
  }
}
