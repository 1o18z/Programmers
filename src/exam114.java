import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        set.add(topping[0]);
        
        for (int top : topping) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }
        
        for (int top : topping) {
            set.add(top);
            map.put(top, map.get(top) - 1);
            
            if (map.get(top) == 0) {
                map.remove(top);
            }
            if (set.size() == map.size()) {
                result++;
            }
        }
        return result;
    }
}
