class exam49 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            String qwe;
            for(int i=0; i<n; i++){
                qwe = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
                qwe = qwe.substring(qwe.length() -n);
                qwe = qwe.replaceAll("1", "#");
                qwe = qwe.replaceAll("0", " ");
                answer[i] = qwe;
            }
        return answer;
    }
}
