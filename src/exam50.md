class exam50 {
    public int solution(int n) {
        String answer = "";
        while(n>0){
            answer = n % 3 + answer;
            n/=3;
        }
        answer = new StringBuilder(answer).reverse().toString();
        return Integer.parseInt(answer,3);
    }
}
