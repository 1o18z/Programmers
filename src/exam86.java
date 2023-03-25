class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> sumNum = new HashSet<>();
        int length = elements.length;
        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += elements[(j + k) % length];
                }
                sumNum.add(sum);
            }
        }
        return sumNum.size();
    }
}
