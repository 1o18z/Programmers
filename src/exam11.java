class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int i=0; i<array.length;){
            if(array[i] > height){
                i++;
                answer++;
            } else{
                i++;
            }
        }
        return answer;
    }
}