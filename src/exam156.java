class Solution {

  public int solution(int[] a) {
    if (a.length == 1) {
      return 1;
    }
    
    int left = a[0];
    int right = a[a.length - 1];

    int[] leftMin = new int[a.length];
    int[] rightMin = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      if (left > a[i]) {
        left = a[i];
      }
      leftMin[i] = left;
    }

    for (int i = a.length - 2; i > 0; i--) {
      if (right > a[i]) {
        right = a[i];
      }
      rightMin[i] = right;
    }

    int result = 2;
    for (int i = 1; i < a.length - 1; i++) {
      if (a[i] > leftMin[i] && a[i] > rightMin[i]) {
        continue;
      }
      result++;
    }
    return result;
  }
}
