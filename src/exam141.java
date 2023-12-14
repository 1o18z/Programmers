import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {

  static class Music {

    int time;
    String info;
    int index;

    public Music(int time, String info, int index) {
      this.time = time;
      this.info = info;
      this.index = index;
    }

    public int getTime() {
      return time;
    }

    public String getInfo() {
      return info;
    }

    public int getIndex() {
      return index;
    }
  }

  public String solution(String m, String[] musicinfos) {
    Map<String, Music> map = new HashMap<>(); // 제목, 악보
    String[] infos = new String[musicinfos.length];

    for (int i = 0; i < musicinfos.length; i++) {
      infos[i] = changeMusicInfos(musicinfos[i]);
    }

    int index = 0;
    for (String info : infos) {
      String[] musicInfo = info.split(",");
      String key = musicInfo[2];
      int streamingTime = calculateTime(musicInfo[0], musicInfo[1]);
      String value = processMusic(streamingTime, musicInfo[3]);
      map.put(key, new Music(streamingTime, value, index++));
    }
    String changedM = changeMusicInfos(m);
    List<String> result = map.entrySet().stream()
        .filter(
            e -> e.getValue().getInfo().contains(changedM))
        .map(Entry::getKey)
        .collect(Collectors.toList());

    if (result.isEmpty()) {
      return "(None)";
    }
    result.sort((o1, o2) -> {
      int timeDiff = map.get(o2).getTime() - map.get(o1).getTime();
      if (timeDiff == 0) {
        return map.get(o1).getIndex() - map.get(o2).getIndex();
      }
      return timeDiff;
    });
    return result.get(0);
  }

  private String changeMusicInfos(String musicInfo) {
    return musicInfo.replaceAll("C#", "H")
        .replaceAll("D#", "I")
        .replaceAll("F#", "J")
        .replaceAll("G#", "K")
        .replaceAll("A#", "L");
  }

  private int calculateTime(String startTime, String endTime) {
    String[] start = startTime.split(":");
    String[] end = endTime.split(":");
    return processTime(end) - processTime(start);
  }

  private int processTime(String[] time) {
    return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
  }

  private String processMusic(int time, String musicInfo) {
    if (musicInfo.length() == time) {
      return musicInfo;
    }
    if (musicInfo.length() < time) {
      return extendString(musicInfo, time);
    }
    return musicInfo.substring(0, time);
  }

  private String extendString(String musicInfo, int time) {
    StringBuilder sb = new StringBuilder(time);
    while (sb.length() < time) {
      sb.append(musicInfo);
    }
    return sb.substring(0, time);
  }
}
