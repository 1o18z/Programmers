package src;
import java.util.*;
public class exam14 {
  public int solution(int[] numbers) {
    Arrays.sort(numbers);
    return (numbers[numbers.length - 1] * numbers[numbers.length - 2]);
  }
}

