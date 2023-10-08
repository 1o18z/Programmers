import java.util.Map;
import java.util.HashMap;

class Solution {
    static String[] board = {"R","T","C","F","J","M","A","N"};
    static Map<String, Integer> map;
    
    public String solution(String[] survey, int[] choices) {
        map = new HashMap<>();
        init();
        getScore(survey, choices);

        String result = "";
        return selectType(result);
    }
    
    void init(){
        for(int i=0; i<board.length; i++){
            map.put(board[i], 0);
        }
    }
    
    void getScore(String[] survey, int[] choices){
        for(int i=0; i<survey.length; i++){
            String before = survey[i].split("")[0];
            String after = survey[i].split("")[1];
            
            if(choices[i] > 4){
                map.put(after, map.get(after) + (choices[i]-4));
            }
            else if(choices[i] < 4){
                if(choices[i] == 1) map.put(before, map.get(before) + 3); 
                if(choices[i] == 2) map.put(before, map.get(before) + 2);
                if(choices[i] == 3) map.put(before, map.get(before) + 1); 
            }
        }    
    }
    
    String selectType(String result){
        result += (map.get("R") >= map.get("T")) ? "R" : "T";
        result += (map.get("C") >= map.get("F")) ? "C" : "F";
        result += (map.get("J") >= map.get("M")) ? "J" : "M";
        result += (map.get("A") >= map.get("N")) ? "A" : "N";
        return result;
    }
}
