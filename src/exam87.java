class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int all = yellow + brown;
        for(int i=3; i<all/2; i++){
            for(int j=3; j<all/2; j++){
                if(i * j == all && (i-2)*(j-2)==yellow){
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return -1;
    }
}
