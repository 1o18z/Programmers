import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int m : moves){
            for(int j=0; j<board.length; j++){
                if(board[j][m-1] != 0){
                    if(!stack.isEmpty() && stack.peek() == board[j][m-1]){
                        stack.pop();
                        count+=2;
                    }else{
                        stack.push(board[j][m-1]);
                    }
                    board[j][m-1] = 0;
                    break;
                } 
            }
        }
        return count;
    }
}
