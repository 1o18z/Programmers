import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
class Solution {
    public int[] solution(String[] gems) {
        int allGems = new HashSet<>(Arrays.asList(gems)).size();
 
        int[] result = new int[2];
        int length = Integer.MAX_VALUE;
        int start = 0;
               
        Map<String, Integer> map = new HashMap<>();
        
        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
 
            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
 
            if (map.size() == allGems && length > (end - start)) {
                length = end - start;
                result[0] = start + 1;
                result[1] = end + 1;
            }
        }
 
        return result;
    }

}
