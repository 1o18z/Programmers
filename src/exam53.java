class Solution {
    public boolean solution(int x) {
        int number = 0;
        int i = x;
        
        while(i>0){
            number += i%10; 
            i/=10; 
        }
        boolean answer = x%number == 0 ? true : false; 
        return answer;
    }
}
