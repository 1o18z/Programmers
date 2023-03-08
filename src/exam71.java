import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> list = new ArrayList<>();

        Collections.sort(list);
        Arrays.sort(completion);

        for(int i=0; i<participant.length; i++){
            list.add(participant[i]);
        }
        for(int i=0; i<completion.length; i++){
            if(list.contains(completion[i])){
                list.remove(completion[i]);
            }
        }
        answer += list.get(0);
        return answer;
    }
}
