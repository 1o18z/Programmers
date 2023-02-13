import java.util.*;

public class exam41 {
  public int[] solution(int[] arr) {
    Stack<Integer> stack = new Stack<>();

    for (int n : arr) {
      if (stack.isEmpty() || stack.peek() != n) {
        stack.add(n);
      }
    }
    int[] answer = new int[stack.size()];
    int index = 0;
    for (int n : stack) {
      answer[index++] = n;
    }
    return answer;
  }
}