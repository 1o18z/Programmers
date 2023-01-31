class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        for(int i=0; i<array.length;){
            if(array[i] == n){
                answer++;
                i++;
            } else{
                i++;
            }
        }
        return answer;
    }
}