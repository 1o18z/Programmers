class Solution {
    public void[] solution(String[] strlist) {
        int[] answer = {};
        for(int i=0; i<strlist.length; i++){
            answer[i] = strlist[i].length();
        }
        return answer;
    }
}