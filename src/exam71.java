import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        List<String> list = new LinkedList<>(Arrays.asList(participant));

        Collections.sort(list);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++){
            if(list.contains(completioåçn[i])){
                list.remove(completion[i]);
            }
        }
        return list.get(0);
    }
}
// 효율성 테스트 통과!!
