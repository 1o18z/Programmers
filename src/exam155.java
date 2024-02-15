import java.util.Arrays;

class Solution {

  public static int solution(int[] A, int[] B) {
    int count = 0;
    Arrays.sort(A);
    Arrays.sort(B);

    int locationA = 0;
    int locationB = 0;

    while (locationA < A.length && locationB < B.length) {
      if (A[locationA] < B[locationB]) {
        locationA++;
        locationB++;
        count++;
      } else {
        locationB++;
      }
    }

    return count;
  }
}
