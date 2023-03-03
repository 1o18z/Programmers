class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                answer += ch;
            } else{
                if(ch>='a' & ch<='z'){
                    answer += (char)('a' + (ch-'a'+n)%26);
                }
                else{
                    answer += (char)('A' + (ch-'A'+n)%26);
                }
            }
        }
        return answer;
    }
}
