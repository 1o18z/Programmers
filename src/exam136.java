import java.util.Map;
import java.util.HashMap;

class Solution {

  static Map<Integer, Integer> map = new HashMap<>();
  static int currentHealth;
  static int count = 0;

  public int solution(int[] bandage, int health, int[][] attacks) {
    currentHealth = health;
    int size = attacks[attacks.length - 1][0];

    for (int[] attack : attacks) {
      map.put(attack[0], attack[1]);
    }

    for (int time = 1; time <= size; time++) {
      if (isAttacked(time)) {
        receiveAttack(time);
        if (currentHealth <= 0) {
          return -1;
        }
      } else {
        charge(bandage, health);
      }
    }
    return currentHealth;
  }

  private boolean isAttacked(int time) {
    return map.containsKey(time);
  }

  private void receiveAttack(int time) {
    currentHealth -= map.get(time);
    count = 0;
  }

  private void charge(int[] bandage, int health) {
    count++;
    currentHealth += bandage[1];

    checkContinuous(bandage);
    if (currentHealth > health) {
      currentHealth = health;
    }
  }

  private void checkContinuous(int[] bandage) {
    if (count == bandage[0]) {
      count = 0;
      currentHealth += bandage[2];
    }
  }
}
