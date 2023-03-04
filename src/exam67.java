import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int idx=0;
        for(int i=0; i<commands.length; i++){
                int[] cpy = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(cpy);
                result[idx++] = cpy[commands[i][2]-1];
            }
        
        return result;
    }
}
