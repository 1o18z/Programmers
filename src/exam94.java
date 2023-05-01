public class Solution {
    public int solution(int n) {
        int count = 0;

        while(n!=0){
            if(n%2==0){
                n/=2;
            } else{
                n--;
                count++;    
            }
        }
        return count;
    }
}
