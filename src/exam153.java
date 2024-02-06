import java.util.ArrayList;
import java.util.List;

class Solution {

  static class Info {

    private String language;
    private String type;
    private String career;
    private String soulFood;
    private int score;

    public Info(String info) {
      String[] infos = info.split(" ");
      this.language = infos[0];
      this.type = infos[1];
      this.career = infos[2];
      this.soulFood = infos[3];
      this.score = Integer.parseInt(infos[4]);
    }

    public boolean match(String language, String type, String career, String soulFood, int score) {
      return (language.equals("-") || language.equals(this.language))
          && (type.equals("-") || type.equals(this.type))
          && (career.equals("-") || career.equals(this.career))
          && (soulFood.equals("-") || soulFood.equals(this.soulFood))
          && score <= this.score;
    }
  }

  public static int[] solution(String[] infos, String[] querys) {
    List<Info> list = new ArrayList<>();
    int[] result = new int[querys.length];

    for (String info : infos) {
      list.add(new Info(info));
    }

    for (int i = 0; i < querys.length; i++) {
      String[] query = querys[i].split(" and ");
      String[] finalQuery = query[3].split(" ");

      int count = 0;
      for (Info info : list) {
        if (info.match(query[0], query[1], query[2], finalQuery[0],
            Integer.parseInt(finalQuery[1]))) {
          count++;
        }
      }
      result[i] = count;
    }
    return result;
  }
}
