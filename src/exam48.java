class exam48 {
  public int solution(int[] absolutes, boolean[] signs) {
    int answer = 123456789;
    int[] arr = new int[signs.length];
    for(int i=0; i<absolutes.length; i++){
      if(signs[i] == false){
        arr[i] = 0 - absolutes[i];
      } else{
        arr[i] = absolutes[i];
      }
    }
    int sum = 0;
    for(int i=0; i<arr.length; i++){
      sum += arr[i];
    }
    return sum;
  }
}