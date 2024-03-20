import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Naver {

  static class Student {

    int index;
    
    int selfScore;
    int minScore;
    int maxScore;
    int sum = 0;
    boolean isUnique;

    List<Integer> scores;

    public Student(int index, int sum, List<Integer> scores) {
      this.index = index;
      this.selfScore = scores.get(index);
      this.scores = scores;
      this.sum = sum;
      checkUnique();
    }

    private void checkUnique() {
      List<Integer> temp = new ArrayList<>(scores).stream().sorted().collect(Collectors.toList());
      this.minScore = temp.get(0);
      this.maxScore = temp.get(temp.size() - 1);

      int selfCount = Collections.frequency(scores, selfScore);
      if ((selfScore == minScore || selfScore == maxScore) && selfCount == 1) {
        scores.remove(index);
        this.sum -= selfScore;
        this.isUnique = true;
        return;
      }
      this.isUnique = false;
    }
  }

  static Map<Integer, Student> map;
  static StringBuilder sb;

  private static String solution(int[][] scores) {
    map = new HashMap<>();
    sb = new StringBuilder();

    for (int i = 0; i < scores[0].length; i++) {
      List<Integer> list = new ArrayList<>();
      int sum = 0;
      for (int[] score : scores) {
        list.add(score[i]);
        sum += score[i];
      }
      
      map.put(i, new Student(i, sum, list));
    }

    for (int i = 0; i < map.size(); i++) {
      Student student = map.get(i);
      double result = ((double) student.sum / student.scores.size());
      sb.append(getResult(result));
    }

    return sb.toString();
  }

  private static char getResult(double result) {
    if (result < 50) return 'F';
    if (result < 70) return 'D';
    if (result < 80) return 'C';
    if (result < 90) return 'B';
    return 'A';
  }

  public static void main(String[] args) {
    System.out.println(solution(
        new int[][]{
            {100, 90, 98, 88, 65},
            {50, 45, 99, 85, 77},
            {47, 88, 95, 80, 67},
            {61, 57, 100, 80, 65},
            {24, 90, 94, 75, 65}}));
    System.out.println(solution(new int[][]{{50, 90}, {50, 87}}));
    System.out.println(solution(new int[][]{
        {70, 49, 90},
        {68, 50, 38},
        {73, 31, 100}}));
  }
}
