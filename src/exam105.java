import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<Integer>();
        String [] str = s.replaceAll("[{}]", " ").trim().split(" ,");
        int[] result = new int[str.length];
        int idx = 0;
        
        Arrays.sort(str, (i, j)->(i.length()-j.length()));
        
        for(String ss : str){
            for(String sss : ss.split(",")){
                int a  = Integer.parseInt(sss.trim());
                
                if(set.contains(a)) continue;
                set.add(a);
                result[idx++] = a;
            }
        }
        return result;
    }
}
