class Solution {

  public static String solution(int[] numbers, String hand) {
    StringBuilder sb = new StringBuilder();
    int leftIndex = 10;
    int rightIndex = 12;

    for (int number : numbers) {
      if (number == 1 || number == 4 || number == 7) {
        sb.append("L");
        leftIndex = number;
      } else if (number == 3 || number == 6 || number == 9) {
        sb.append("R");
        rightIndex = number;
      } else {
        int leftLength = calculateLength(leftIndex, number);
        int rightLength = calculateLength(rightIndex, number);

        if (leftLength > rightLength) {
          sb.append("R");
          rightIndex = number;
        } else if (leftLength < rightLength) {
          sb.append("L");
          leftIndex = number;
        } else {
          if (hand.equals("right")) {
            sb.append("R");
            rightIndex = number;
          } else {
            sb.append("L");
            leftIndex = number;
          }
        }
      }
    }
    return sb.toString();
  }

  public static int calculateLength(int index, int number) {
    index = checkZero(index);
    number = checkZero(number);

    int x = (index - 1) / 3;
    int y = (index - 1) % 3;
    int numberX = number / 3;
    int numberY = 1;

    return Math.abs(x - numberX) + Math.abs(y - numberY);
  }

  public static int checkZero(int value) {
    if (value == 0) {
      return 11;
    }
    return value;
  }
}
