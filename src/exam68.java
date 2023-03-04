import java.util.Arrays;
class Solution {
    public int solution(int[] nums) {
        int[] arr = Arrays.stream(nums)
                        .distinct()
                        .sorted()
                        .toArray();
        if(arr.length > nums.length/2){
            int[] str = Arrays.copyOfRange(arr, 0, nums.length/2);
            return str.length;
        }
        return arr.length;
    }
}
