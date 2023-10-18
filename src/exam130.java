class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; convert.length() <= t * m; i++){
            convert.append(Integer.toString(i, n));
        }
        
        for(int i = p - 1;  answer.length() < t; i += m){
            answer.append(convert.charAt(i));
        }
        
        return answer.toString().toUpperCase();
    }
}
