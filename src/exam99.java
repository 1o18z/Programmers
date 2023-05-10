import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] arr = new int[photo.length];
        List<String> list = new ArrayList<>(Arrays.asList(name));
        
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if(list.indexOf(photo[i][j]) != -1){
                    arr[i] += yearning[list.indexOf(photo[i][j])];
                }
            }
        }
        return arr;
    }
}
