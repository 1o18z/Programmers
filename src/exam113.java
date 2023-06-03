import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int j=0; j<=discount.length-10; j++){
            Map<String, Integer> map2 = new HashMap<>();
            
            for(int k=0; k<10; k++){
                map2.put(discount[j+k], map2.getOrDefault(discount[j+k], 0) +1);
            }
        
        boolean boo = true;
        for(String m : map.keySet()){
            if(map.get(m) > map2.getOrDefault(m, 0)){
                boo = false;
                break;
            }
        }
        if(boo) result++;
        }
        return result;
    }
}
