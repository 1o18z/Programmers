import java.util.*;

public class exam37 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();

    int A = scan.nextInt();
    for (int i = 1; i <= A; i++) {
      if (A % i == 0) {
        list.add(i);
      }
    }
    System.out.println(list);
  }
}
