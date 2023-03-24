class Solution {
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return count;
    }
    
    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){
            if(target == sum) count++;        
        } else{
                dfs(numbers, depth+1, target, sum + numbers[depth]);
                dfs(numbers, depth+1, target, sum - numbers[depth]);
        }
    }   
}
