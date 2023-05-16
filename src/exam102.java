import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(String t : terms){
            String[] splitTerms = t.split(" ");
            map.put(splitTerms[0], Integer.parseInt(splitTerms[1]));
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] splitPrivacies = privacies[i].split(" ");
            int date = getDate(today);
            
            if(getDate(splitPrivacies[0]) + (map.get(splitPrivacies[1]) * 28) <= date){
                list.add(i+1);
            }
        }
        return list.stream().mapToInt(Integer -> Integer).toArray();
    }
    
    private int getDate(String date){
        String[] splitDate = date.split("\\.");
        int year = (Integer.parseInt(splitDate[0])) * 12 * 28;
        int month = (Integer.parseInt(splitDate[1])) * 28;
        int day = Integer.parseInt(splitDate[2]);
        return year + month + day;
    }
}
