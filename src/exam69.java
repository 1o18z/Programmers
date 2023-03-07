import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] total = {0,0,0};
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i]) total[0] ++;
            if(answers[i] == two[i]) total[1] ++;
            if(answers[i] == three[i]) total[2] ++;
        }
        
        int max = Math.max(Math.max(total[0], total[1]), total[2]);
        List<Integer> list = new ArrayList<>();
        if(max == total[0]) list.add(1);
        if(max == total[1]) list.add(2);
        if(max == total[2]) list.add(3);
        
        return list.stream().mapToInt(v -> v.intValue()).toArray();
    }
}
