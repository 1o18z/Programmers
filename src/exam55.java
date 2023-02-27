class Solution {
    public int[] solution(long n) {
        String str = "" + n;
        int[] answer = new int[str.length()];
        int idx = 0;
        
        while(n != 0){
            answer[idx++] = (int)(n%10);
            n/=10;
        }
        return answer;
    }
}
