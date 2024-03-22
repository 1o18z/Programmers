public class Solution {

  public static int solution(String name) {
    int result = 0;
    int movement = name.length() - 1;

    for (int i = 0; i < name.length(); i++) {
      result += Math.min(name.charAt(i) - 'A', ('Z' + 1) - name.charAt(i));

      int position = i + 1;
      while (position < name.length() && name.charAt(position) == 'A') {
        position++;
      }

      movement = Math.min(movement,
          Math.min(Math.min((name.length() - 1), ((i * 2) + name.length() - position)),
              (name.length() - position) * 2 + i));
    }
    
    return result + movement;
  }

  /*public static void main(String[] args) {
    System.out.println(solution("JEROEN"));
    System.out.println(solution("JAN"));
  }*/
}
