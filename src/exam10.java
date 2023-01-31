class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        for(int i=0; i<2; i++){
            if(sides[0] > sides[1] && sides[0] > sides[2]){
                if(sides[0] < sides[1] + sides[2]){
                    answer = 1;
                }else{
                    answer = 2;
                }
            } else if(sides[1] > sides[0] && sides[1] > sides[2]){
                if(sides[1] < sides[0] + sides[2]){
                    answer = 1;
                }else{
                    answer = 2;
                }
            } else if(sides[2] > sides[0] && sides[2] > sides[1]){
                if(sides[2] < sides[1] + sides[0]){
                    answer = 1;
                }else{
                    answer = 2;
                }
            } else{
                if(sides[0] < sides[1] + sides[2]){
                    answer = 1;
                }else if(sides[1] < sides[0] + sides[2]){
                    answer = 1;
                }else if(sides[2] < sides[1] + sides[0]){
                    answer = 1;
                } else{
                    answer = 2;
                }
            }
        }
        return answer;
    }
}