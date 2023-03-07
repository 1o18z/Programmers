import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        for(int i=0; i<str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        
        answer += arr[0] + " " + arr[arr.length-1];
        return answer;
    }
}
