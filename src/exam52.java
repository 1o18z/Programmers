import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        int small = arr2[0];
        int[] result = new int[arr.length-1];
        
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != small){
                result[count++] = arr[i];
            } 
        }
        return result;
    }
}
