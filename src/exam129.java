import java.util.ArrayList;
import java.util.List;
class Solution {
    static List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        
        int[][] arr = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    void hanoi(int n, int start, int end, int middle){
        if(n==1) {
            list.add(new int[]{start,end});
            return;
        }
        hanoi(n-1, start, middle, end);
        list.add(new int[]{start, end});
        hanoi(n-1, middle, end, start);
    }
}
