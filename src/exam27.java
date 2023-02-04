import java.util.Arrays;

public class exam27 {
  public int solution(String before, String after) {
    char[] bf = before.toCharArray();
    char[] af = after.toCharArray();

    Arrays.sort(bf);
    Arrays.sort(af);

    String before2 = new String(bf);
    String after2 = new String(af);

    if (before2.equals(after2)) {
      return 1;
    } else {
      return 0;
    }
  }
}

