import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  static class Room {

    int inTime;
    int outTime;

    public Room(int inTime, int outTime) {
      this.inTime = inTime;
      this.outTime = outTime;
    }
  }

  public static int solution(String[][] book_time) {
    List<Room> list = new ArrayList<>();
    Queue<Integer> queue = new PriorityQueue<>();

    for (String[] time : book_time) {
      list.add(new Room(calculate(time[0]), calculate(time[1]) + 10));
    }

    list.sort((o1, o2) -> {
      if (o1.inTime == o2.inTime) {
        return o1.outTime - o2.outTime;
      }
      return o1.inTime - o2.inTime;
    });

    for (Room room : list) {
      if (queue.isEmpty()) {
        queue.add(room.outTime);
        continue;
      }
      if (queue.peek() <= room.inTime) {
        queue.poll();
        queue.add(room.outTime);
      } else {
        queue.add(room.outTime);
      }
    }
    return queue.size();
  }

  private static int calculate(String value) {
    int hours = Integer.parseInt(value.split(":")[0]);
    int minutes = Integer.parseInt(value.split(":")[1]);
    return (hours * 60) + minutes;
  }
}
