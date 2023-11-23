class Solution {
    public int solution(String s) {
        int result = s.length();
        int count = 1;
        for(int i = 1; i <= s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String value = s.substring(0, i);
            for(int j = i; j <= s.length(); j += i){
                int end = Math.min(i + j, s.length());
                String compare = s.substring(j,end);
                if(value.equals(compare)){
                    count++;
                }else{
                    if(count >= 2){
                        sb.append(count);
                    }
                    sb.append(value);
                    value = compare;
                    count = 1;
                }
            }
            sb.append(value);
            result = Math.min(sb.length(), result);
        }
        return result;
    }
}
