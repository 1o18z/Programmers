import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i], i);
        }
        // keySet이 다른 keySet의 substring인지 확인
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
