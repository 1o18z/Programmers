import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] failRate = new double[N];
        int[] challenge = new int[N];
        int[] result = new int[N];
        
        for (int i = 1; i <= N; i++) {
            int failCount = 0;
            for (int stage : stages) {
                if (stage == i) {
                    failCount++;
                }
                if (stage >= i) {
                    challenge[i - 1]++;
                }
            }
            failRate[i - 1] = challenge[i - 1] > 0 ? (double) failCount / challenge[i - 1] : 0;
        }

        Integer[] arr = IntStream.range(0, N)
            .boxed()
            .toArray(Integer[]::new);
        Arrays.sort(arr, Comparator.comparingDouble((Integer index) -> failRate[index])
                    .reversed()
                    .thenComparingInt(index -> index));

        for (int i = 0; i < N; i++) {
            result[i] = arr[i] + 1;
        }
        
        return result;
    }
}
