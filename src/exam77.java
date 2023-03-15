import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int count = 0;   
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")){
                continue;
            }
    
            babbling[i] = babbling[i].replaceAll("aya"," ").replaceAll("ye"," ").replaceAll("woo"," ").replaceAll("ma"," ").replaceAll(" ","");   
        }
        
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].length() < 1){
                count++;
            }
        }
        return count;
    }
}
