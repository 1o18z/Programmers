import java.util.Map;
import java.util.HashMap;

class Solution {

  public int solution(int[] bandage, int health, int[][] attacks) {
    Map<Integer, Integer> map = new HashMap<>();
    int size = attacks[attacks.length - 1][0];
    int currentHealth = health;
    int count = 0;

    for (int i = 0; i < attacks.length; i++) {
      map.put(attacks[i][0], attacks[i][1]);
    }

    for (int time = 1; time <= size; time++) {
      if (map.containsKey(time)) {
        currentHealth -= map.get(time);
        count = 0;

        if (currentHealth <= 0) {
          return -1;
        }
      } else {
        count++;
        currentHealth += bandage[1];
        if (count == bandage[0]) {
          count = 0;
          currentHealth += bandage[2];
        }
        if (currentHealth > health) {
          currentHealth = health;
        }
      }
    }
    return currentHealth;
  }
}
