import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>(); 
        List<String> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for (String key : map.keySet()) {
            list.add(key);
        }
        Collections.sort(list, (g1, g2) -> map.get(g2) - map.get(g1));

        List<Integer> list2 = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            String genre = list.get(j);

            int max = 0;
            int idx1 = -1;
            for (int m = 0; m < genres.length; m++) {
                if (genre.equals(genres[m]) && max < plays[m]) {
                    max = plays[m];
                    idx1 = m;
                }
            }

            max = 0;
            int idx2 = -1;
            for (int n = 0; n < genres.length; n++) {
                if (genre.equals(genres[n]) && max < plays[n] && n != idx1) {
                    max = plays[n];
                    idx2 = n;
                }
            }
            list2.add(idx1);
            if(idx2>=0) list2.add(idx2);
        }
        return list2.stream().mapToInt(i -> i).toArray();
    }
}
