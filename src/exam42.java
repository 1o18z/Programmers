import java.util.*;

class exam42 {
  boolean solution(String s) {
    boolean answer = true;
    Stack<Character> stack = new Stack<>();
    char[] arr = s.toCharArray();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '(') {
        stack.push('(');
      } else {
        if (stack.isEmpty()) {
          stack.push(')');
          break;
        } else {
          stack.pop();
        }
      }
    }
    if (stack.isEmpty()) {
      answer = true;
    } else {
      answer = false;
    }
    stack.clear();

    return answer;
  }
}