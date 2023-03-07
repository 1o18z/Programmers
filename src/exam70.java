import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        String[] str = s.split(" ");
        for(int i=0; i<str.length; i++){
            list.add(Integer.parseInt(str[i]));
        }
        
        Collections.sort(list);
        answer += list.get(0) + " " + list.get(list.size() -1);
        return answer;
    }
}
