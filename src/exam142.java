import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  public static int solution(int n, int k, int[] enemy) {
    if (enemy.length <= k) {
      return enemy.length;
    }

    Queue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      queue.add(enemy[i]);
    }

    int count = 0;
    for (int i = k; i < enemy.length; i++) {
      int value = enemy[i];

      if (queue.peek() < enemy[i]) {
        value = queue.poll();
        queue.add(enemy[i]);
      }
      if (n >= value) {
        n -= value;
      } else {
        break;
      }
      count++;
    }
    return count + k;
  }
}
