import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(String re : record){
            String[] str = re.split(" ");
            
            if(str[0].equals("Enter")){
                map.put(str[1], str[2]);
                list.add(str[1] + "님이 들어왔습니다.");
            }
            if(str[0].equals("Leave")){
                list.add(str[1] + "님이 나갔습니다.");
            }
            if(str[0].equals("Change")){
                map.put(str[1], str[2]);
            }
        }
        
        String[] result = new String[list.size()];
        for(int i=0; i<result.length; i++){
            String userId = list.get(i).substring(0, list.get(i).indexOf("님"));
            result[i] = list.get(i).replace(userId, map.get(userId));
        }
        return result;
    }
}
