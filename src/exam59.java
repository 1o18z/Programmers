import java.util.*;
class Solution {
    public long solution(long n) {
        String answer = "";
        String str = "" + n;
        String[] arr = str.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0; i<arr.length; i++){
            answer += arr[i];
        }
        return Long.parseLong(answer);
    }
}
