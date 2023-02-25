class Solution {
    public String solution(String s) {
        String[] str = s.split("");
        int count = 0;
        String answer = "";
        for(String ss : str){
            count = ss.equals(" ") ? 0 : count + 1;
            answer += count%2==0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return answer;
    }
}
