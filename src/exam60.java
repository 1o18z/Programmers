class Solution {
    public int solution(int n) {
        int count = 0;
        for(int i=1; i<n; i++){
            if(n%i==1){
                count++;
            }
        }
        int[] arr = new int[count];
        int idx=0;
        for(int i=1; i<n; i++){
            if(n%i==1){
                arr[idx++] = i;
            }
        }
        return arr[0];
    }
}
