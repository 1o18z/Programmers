import java.util.PriorityQueue;
import java.util.Collections;
class Solution {
    public int solution(int[] A, int[] B) {
        int sum=0;
        PriorityQueue<Integer> queA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> queB = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<A.length; i++) {
	        queA.offer(A[i]);
	        queB.offer(B[i]);
        }

        while (!queA.isEmpty()) {
	        if (queA.poll() < queB.peek()) {
		        queB.poll();
		        sum++;
	        }
        }
        return sum;
    }
}
