class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        int p = price;
        for(int i=1; i<=count; i++){
            price = p*i;
            sum+=price;
        }
        if(money >= sum){
            return 0;
        }
        answer = sum - money; 
        return answer;
    }
}
