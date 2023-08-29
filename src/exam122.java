import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static List<String> list;
    static boolean[] isVisited;

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        isVisited = new boolean[tickets.length];
        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));

        String startAirport = "ICN";
        dfs(startAirport, tickets, 0);

        return list.toArray(new String[list.size()]);
    }

    static void dfs(String current, String[][] tickets, int count) {
        list.add(current);

        if (count == tickets.length) {
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!isVisited[i] && current.equals(tickets[i][0])) {
                isVisited[i] = true;
                dfs(tickets[i][1], tickets, count + 1);
              
                if (list.size() == tickets.length + 1) {
                    return;
                }
              
                isVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
