import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = new int[2];
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<words.length; i++){
            if(list.contains(words[i])){
                result[0] = i%n+1;
                result[1] = i/n+1;
                break;
            }
            list.add(words[i]);
            
            if(i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                result[0] = i%n+1;
                result[1] = i/n+1;
                break;
            }  
        }
        return result;
    }
}