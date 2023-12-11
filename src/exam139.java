import java.util.ArrayList;
import java.util.List;

class Solution {

  public static int solution(String str1, String str2) {
    int base = 65536;
    List<String> list1 = splitLetter(str1);
    List<String> list2 = splitLetter(str2);

    List<String> duplicationList = new ArrayList<>();
    List<String> allList = new ArrayList<>();

    for (String s : list1) {
      if (list2.remove(s)) {
        duplicationList.add(s);
      }
      allList.add(s);
    }
    allList.addAll(list2);

    if (allList.size() == 0) {
      return base;
    }
    double result = (double) duplicationList.size() / (double) allList.size();
    return (int) (result * base);
  }

  private static List<String> splitLetter(String value) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < value.length() - 1; i++) {
      String letter = value.substring(i, i + 2).toUpperCase();
      if (isLetter(letter)) {
        list.add(letter);
      }
    }
    return list;
  }

  private static boolean isLetter(String letter) {
    char[] chars = letter.toCharArray();
    return chars[0] >= 'A' && chars[0] <= 'Z' && chars[1] >= 'A' && chars[1] <= 'Z';
  }
}
