import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Solution {

  static class File {

    String header;
    String number;
    String tail;

    public File(String file, int startNumberIdx, int endNumberIdx) {
      this.header = file.substring(0, startNumberIdx);
      this.number = file.substring(startNumberIdx, endNumberIdx + 1);
      this.tail = file.substring(endNumberIdx + 1);
    }

    public String getHeader() {
      return header;
    }

    public String getNumber() {
      return number;
    }

    public String getTail() {
      return tail;
    }
  }

  public String[] solution(String[] files) {
    String[] result = new String[files.length];
    List<File> fileList = new ArrayList<>();

    for (String file : files) {
      int startNumberIdx = -1;
      boolean first = true;
      int size = 0;

      for (int j = 0; j < file.length(); j++) {
        if (Character.isDigit(file.charAt(j))) {
          if (first) {
            startNumberIdx = j;
            first = false;
          }
          size++;
        } else {
          if (!first) {
            break;
          }
        }
      }

      int endNumberIdx = startNumberIdx + size - 1;
      File eachFile = new File(file, startNumberIdx, endNumberIdx);
      fileList.add(eachFile);
    }

    fileList.sort((o1, o2) -> {
      if (o1.getHeader().toLowerCase(Locale.ROOT).compareTo(o2.getHeader().toLowerCase(Locale.ROOT))> 0) {
        return 1;
      } else if (o1.getHeader().toLowerCase(Locale.ROOT).compareTo(o2.getHeader().toLowerCase(Locale.ROOT))< 0) {
        return -1;
      } else {
        return Integer.compare(Integer.parseInt(o1.getNumber()), Integer.parseInt(o2.getNumber()));
      }
    });

    int index = 0;
    for (File file : fileList) {
      result[index++] = file.getHeader() + file.getNumber() + file.getTail();
    }

    return result;
  }
}
