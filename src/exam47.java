class exam47 {
  public int solution(int[] numbers) {
    int sum = 45;
    for (int i = 0; i < numbers.length; i++) {
      sum -= numbers[i];
    }
    return sum;
  }
}